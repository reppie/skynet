package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Geo;

public class GeoDaoImpl extends GeoDao{

	@Override
	public void delete(Domain domain) {
		Geo geo = (Geo) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + geo.getId());
	}
	
	@Override
	public void insert(Domain domain) {
		Geo geo = (Geo) domain;
		
		int id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (geo_type_id, coordinates) " +
				"VALUES (" + geo.getType().getId() + ", '" 
							+ geo.getCoordinates() + "')"					
				);
		geo.setId(id);
	}

	@Override
	public Geo select(long id) {
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
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
