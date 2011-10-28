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
		Connection conn = (Connection) this.getConnection();
		
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + boundingBoxType.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void insert(Domain domain) {
		Connection conn = (Connection) this.getConnection();
		
		BoundingBoxType boundingBoxType = (BoundingBoxType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (text) VALUES ('" + boundingBoxType.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			boundingBoxType.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public BoundingBoxType select(long id) {
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

	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}
}
