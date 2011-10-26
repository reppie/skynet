package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.UserDAO;
import toctep.skynet.backend.dal.domain.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDAOImpl implements UserDAO {

	@Override
	public User selectUser(String name) {	
		Connection conn = MySQL.getInstance().getConnection();
		
		User user = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT name FROM twitter_user WHERE name = '" + name + "'");
			rs.first();
			user = new User(rs.getString("name"));
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
	public void insertUser(User user) {
		Connection conn = MySQL.getInstance().getConnection();
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(
					"INSERT INTO twitter_user" +
						"(name)" +
					"VALUES " +
						"('" + user.getName() + "')");
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
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
