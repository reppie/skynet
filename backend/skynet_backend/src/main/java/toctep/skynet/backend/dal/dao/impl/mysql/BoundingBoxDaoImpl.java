package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.domain.BoundingBox;
import toctep.skynet.backend.dal.domain.Domain;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BoundingBoxDaoImpl extends BoundingBoxDao{

	@Override
	public void delete(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoundingBox select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		BoundingBox boundingBox = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);
			rs.first();
			boundingBox = new BoundingBox();
			boundingBox.setId(id);
//			boundingBox.setType(type); // TODO
			boundingBox.setCoordinates(rs.getString("coordinates"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boundingBox;
	}
	
	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

}
