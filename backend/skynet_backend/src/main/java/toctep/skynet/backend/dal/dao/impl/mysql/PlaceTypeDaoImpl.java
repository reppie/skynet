package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.place.PlaceType;

public class PlaceTypeDaoImpl extends PlaceTypeDao {

	@Override
	public void insert(Domain domain) {
		PlaceType placeType = (PlaceType) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (text) VALUES ('" + placeType.getText() + "')"
		);
		
		placeType.setId(id);
	}

	@Override
	public PlaceType select(long id) {
		PlaceType placeType = new PlaceType();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);			

		placeType.setId(id);
		
		try {
			placeType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return placeType;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain domain) {
		PlaceType placeType = (PlaceType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + placeType.getId());		
	}
	
	@Override
	public boolean exists(Domain domain) {
		PlaceType placeType = (PlaceType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + placeType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
