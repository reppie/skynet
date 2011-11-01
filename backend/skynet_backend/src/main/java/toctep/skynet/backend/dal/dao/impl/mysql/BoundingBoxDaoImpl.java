package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;

public class BoundingBoxDaoImpl extends BoundingBoxDao {

	@Override
	public void delete(Domain<Long> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + boundingBox.getId());
	}
	
	@Override
	public void insert(Domain<Long> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		
		long id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (bounding_box_type_id, coordinates) " +
			"VALUES (" + boundingBox.getType().getId() + ", '" + 
					     boundingBox.getCoordinates() + "')"
		);
		
		((BoundingBox) boundingBox).setId(id);
	}

	@Override
	public BoundingBox select(Long id) {
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
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean exists(Domain<Long> domain) {
		BoundingBox boundingBox = (BoundingBox) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + boundingBox.getId());
	}
	
	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
