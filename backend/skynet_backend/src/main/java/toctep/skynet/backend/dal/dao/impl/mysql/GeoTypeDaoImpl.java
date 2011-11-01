package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoTypeDaoImpl extends GeoTypeDao{

	@Override
	public void insert(Domain<Long> domain) {
		GeoType geoType = (GeoType) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(geoType.getText(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		geoType.setId(id);
	}

	@Override
	public GeoType select(Long id) {
		GeoType geoType = new GeoType();
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		geoType.setId(id);
		try {
			geoType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return geoType;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		GeoType geoType = (GeoType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + geoType.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		GeoType geoType = (GeoType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + geoType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
