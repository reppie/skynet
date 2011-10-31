package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.GeoType;

public class GeoTypeDaoImpl extends GeoTypeDao{

	@Override
	public void delete(Domain domain) {
		GeoType geoType = (GeoType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + geoType.getId());
	}

	@Override
	public void insert(Domain domain) {
		GeoType geoType = (GeoType) domain;
		
		int id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (text) VALUES ('" + geoType.getText() + "')"
				);
		
		geoType.setId(id);
	}

	@Override
	public GeoType select(long id) {
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
