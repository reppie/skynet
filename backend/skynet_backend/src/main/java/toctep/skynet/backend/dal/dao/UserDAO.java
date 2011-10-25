package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.User;

public interface UserDAO {

	public User selectUser(int id);
	
}
