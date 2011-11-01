package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoDaoImpl extends GeoDao {

	@Override
	public void delete(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + geo.getId());
	}
	
	@Override
	public void insert(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		
		long id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (geo_type_id, coordinates) " +
				"VALUES (" + ((GeoType) geo.getType()).getId() + ", '" 
							+ geo.getCoordinates() + "')"					
				);
		
		geo.setId(id);
	}

	@Override
	public Geo select(Long id) {
		Geo geo = new Geo();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		geo.setId(id);
//		geo.setType(); // TODO!
		try {
			geo.setCoordinates(rs.getString("coordinates"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geo;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean exists(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + geo.getId());
	}
	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
