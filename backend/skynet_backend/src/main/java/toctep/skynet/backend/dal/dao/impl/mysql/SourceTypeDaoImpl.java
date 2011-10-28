package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.SourceType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SourceTypeDaoImpl extends SourceTypeDao {

	@Override
	public void delete(Domain domain) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		SourceType sourceType = (SourceType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + sourceType.getId());
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
		
		SourceType sourceType = (SourceType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (text) VALUES ('" + sourceType.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			sourceType.setId(id);
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
	public SourceType select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		SourceType sourceType = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);			
			rs.first();
			sourceType = new SourceType();
			sourceType.setId(id);
			sourceType.setText(rs.getString("text"));
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
		return sourceType;
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
