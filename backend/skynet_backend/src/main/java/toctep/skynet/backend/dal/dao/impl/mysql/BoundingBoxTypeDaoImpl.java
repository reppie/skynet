package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;

public class BoundingBoxTypeDaoImpl extends BoundingBoxTypeDao{

	@Override
	public void insert(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;

		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(boundingBoxType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		boundingBoxType.setId(id);
	}

	@Override
	public BoundingBoxType select(Integer id) {
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().selectRecord(query, params);
		
		boundingBoxType.setId(id);
		boundingBoxType.setText((String) record.get(1));
		
		return boundingBoxType;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(boundingBoxType.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		return this.exists(boundingBoxType.getId());
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
