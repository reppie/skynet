package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;

public class BoundingBoxDaoImpl extends BoundingBoxDao {
	
	@Override
	public void insert(Domain<Integer> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		
		String query = "INSERT INTO " + tableName + "(bounding_box_type_id, coordinates) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(boundingBox.getType().getId(), Types.BIGINT),
			new Param(boundingBox.getCoordinates(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		((BoundingBox) boundingBox).setId(id);
	}

	@Override
	public BoundingBox select(Integer id) {
		BoundingBox boundingBox = new BoundingBox();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		boundingBox.setId(id);
		boundingBox.setType(BoundingBoxType.select((Integer) record.get(1)));
		boundingBox.setCoordinates((String) record.get(2));
		
		return boundingBox;
	}
	
	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + boundingBox.getId());
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		return this.exists(boundingBox.getId());
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
