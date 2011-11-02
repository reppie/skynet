package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.place.PlaceType;

public class PlaceTypeDaoImpl extends PlaceTypeDao {

	@Override
	public void insert(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(placeType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		placeType.setId(id);
	}

	@Override
	public PlaceType select(Integer id) {
		PlaceType placeType = new PlaceType();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		placeType.setId(id);
		placeType.setText((String) record.get(1));
		
		return placeType;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(placeType.getId(), Types.INTEGER) }
		);
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		PlaceType placeType = (PlaceType) domain;
		return this.exists(placeType.getId());
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id=" + id);
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
