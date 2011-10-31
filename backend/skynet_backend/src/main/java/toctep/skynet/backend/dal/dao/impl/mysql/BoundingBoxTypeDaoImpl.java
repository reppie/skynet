package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.domain.BoundingBoxType;
import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBoxTypeDaoImpl extends BoundingBoxTypeDao{

	@Override
	public void delete(Domain domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + boundingBoxType.getId());	
	}

	@Override
	public void insert(Domain domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;

		int id = MySqlUtil.getInstance().insert(
					"INSERT INTO " + tableName + " (text) VALUES ('" + boundingBoxType.getText() + "')"
					);
		
		boundingBoxType.setId(id);
	}

	@Override
	public BoundingBoxType select(long id) {
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		boundingBoxType.setId(id);
		try {
			boundingBoxType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boundingBoxType;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain domain) {
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + boundingBoxType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
