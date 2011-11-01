package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;

import com.mysql.jdbc.PreparedStatement;

public class BoundingBoxDaoImpl extends BoundingBoxDao{

	@Override
	public void delete(Domain domain) {
		BoundingBox boundingBox = (BoundingBox) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + boundingBox.getId());
	}
	
	@Override
	public void insert(Domain domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (bounding_box_type_id, coordinates) " +
			"VALUES (" + boundingBox.getType().getId() + ", '" + 
					     boundingBox.getCoordinates() + "')"
		);
		boundingBox.setId(id);
	}

	@Override
	public BoundingBox select(long id) {
		BoundingBox boundingBox = new BoundingBox();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		boundingBox.setId(id);
		//boundingBox.setType(); 
		try {
			boundingBox.setCoordinates(rs.getString("coordinates"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boundingBox;
	}
	
	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean exists(Domain domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + boundingBox.getId());
	}
	
	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
