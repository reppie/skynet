package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.User;

public interface UserDAO {

	public void insertUser(User user);
	public User selectUser(String name);
	public void updateUser(User user);
	public void deleteUser(User user);
	
}
