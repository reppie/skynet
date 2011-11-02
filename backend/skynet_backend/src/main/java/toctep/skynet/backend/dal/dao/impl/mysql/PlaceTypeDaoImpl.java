package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.place.PlaceType;

public class PlaceTypeDaoImpl extends PlaceTypeDao {

	@Override
	public void insert(Domain<Long> domain) {
		PlaceType placeType = (PlaceType) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(placeType.getText(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		placeType.setId(id);
	}

	@Override
	public PlaceType select(Long id) {
		PlaceType placeType = new PlaceType();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(placeType.getId(), Types.BIGINT)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);
		
		placeType.setId(id);
		try {
			placeType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return placeType;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Long> domain) {
		PlaceType placeType = (PlaceType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + placeType.getId());		
	}
	
	@Override
	public boolean exists(Domain<Long> domain) {
		PlaceType placeType = (PlaceType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + placeType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
