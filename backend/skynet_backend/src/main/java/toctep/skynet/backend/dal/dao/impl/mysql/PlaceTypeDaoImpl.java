package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.place.PlaceType;

public class PlaceTypeDaoImpl extends PlaceTypeDao {

	@Override
	public void insert(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(placeType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		placeType.setId(id);
	}

	@Override
	public PlaceType select(Integer id) {
		PlaceType placeType = new PlaceType();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		placeType.setId(id);
		placeType.setText((String) row.get("text"));
		
		return placeType;
	}

	@Override
	public void delete(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(placeType.getId(), Types.INTEGER) }
		);
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "text", new Param(placeType.getText(), Types.VARCHAR));
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
