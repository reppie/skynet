package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;

public class BoundingBoxTypeDaoImpl extends BoundingBoxTypeDao{

	@Override
	public void insert(Domain<Long> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;

		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(boundingBoxType.getText(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		boundingBoxType.setId(id);
	}

	@Override
	public BoundingBoxType select(Long id) {
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(boundingBoxType.getId(), Types.BIGINT)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);
		
		boundingBoxType.setId(id);
		try {
			boundingBoxType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boundingBoxType;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Long> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + boundingBoxType.getId());	
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + boundingBoxType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
