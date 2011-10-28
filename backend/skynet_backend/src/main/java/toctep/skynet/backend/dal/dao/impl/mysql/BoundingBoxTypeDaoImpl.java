package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.domain.BoundingBoxType;
import toctep.skynet.backend.dal.domain.Domain;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BoundingBoxTypeDaoImpl extends BoundingBoxTypeDao{

	@Override
	public void delete(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoundingBoxType select(int id) {
		Connection conn = (Connection) this.getConnection();
		
		BoundingBoxType boundingBoxType = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);
			rs.first();
			boundingBoxType = new BoundingBoxType();
			boundingBoxType.setId(id);
			boundingBoxType.setText(rs.getString("text"));
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
		
		return boundingBoxType;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

}
