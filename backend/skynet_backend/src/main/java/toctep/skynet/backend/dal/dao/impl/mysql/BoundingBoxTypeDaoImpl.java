package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;

public class BoundingBoxTypeDaoImpl extends BoundingBoxTypeDao {

	@Override
	public void insert(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;

		String query = "INSERT INTO " + TABLE_NAME + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(boundingBoxType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		boundingBoxType.setId(id);
	}

	@Override
	public BoundingBoxType select(Integer id) {
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		boundingBoxType.setId(id);
		boundingBoxType.setText((String) row.get("text"));
		
		return boundingBoxType;
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(boundingBoxType.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "text", new Param(boundingBoxType.getText(), Types.VARCHAR));
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
