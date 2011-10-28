package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDaoImpl extends UserDao {

	@Override
	public User select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		User user = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT name FROM " + tableName + " WHERE id = " + id);
			rs.first();
			user = new User();
			user.setId(id);
			user.setName(rs.getString("name"));
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
		
		return user;
	}

	@Override
	public void insert(Domain domain) {
		Connection conn = (Connection) this.getConnection();
		
		User user = (User) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
				"INSERT INTO " + tableName + " (name) VALUES ('" + user.getName() + "')",
				Statement.RETURN_GENERATED_KEYS
			);
			user.setId(id);
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
	public void update(Domain domain) {
		// TODO
	}

	@Override
	public void delete(Domain domain) {
		Connection conn = (Connection) this.getConnection();
		
		User user = (User) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + user.getId());
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

}
