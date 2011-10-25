package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.UserDAO;
import toctep.skynet.backend.dal.domain.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDAOImpl implements UserDAO {

	@Override
	public User selectUser(int id) {	
		Connection conn = MySQL.getInstance().getConnection();
		
		User user = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT name FROM twitter_user WHERE id = '" + id + "'");
			rs.first();
			user = new User(id, rs.getString("name"));
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

}
