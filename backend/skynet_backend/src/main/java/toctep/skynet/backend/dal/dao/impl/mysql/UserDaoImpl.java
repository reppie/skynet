package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.User;

public class UserDaoImpl extends UserDao {

	@Override
	public void insert(Domain domain) {
		User user = (User) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (name) VALUES ('" + user.getName() + "')"
		);
		
		user.setId(id);
	}
	
	@Override
	public User select(long id) {
		User user = new User();
		
		ResultSet rs = MySqlUtil.getInstance().select(
			"SELECT name FROM " + tableName + " WHERE id = " + id
		);
		
		user.setId(id);
		
		try {
			user.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain domain) {
		User user = (User) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + user.getId());	
	}

	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
