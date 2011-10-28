package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Hashtag;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class HashtagDaoImpl extends HashtagDao{

	@Override
	public void delete(Domain domain) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		Hashtag hashtag = (Hashtag) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + hashtag.getId());
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
		
		Hashtag hashtag = (Hashtag) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (text) VALUES ('" + hashtag.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			hashtag.setId(id);
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
	public Hashtag select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		Hashtag hashtag = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);			
			rs.first();
			hashtag = new Hashtag();
			hashtag.setId(id);
			hashtag.setText(rs.getString("text"));
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
		return hashtag;
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
