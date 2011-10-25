package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.DAOFacade;
import toctep.skynet.backend.dal.dao.UserDAO;

public class DAOFacadeImpl implements DAOFacade {
	
	private UserDAO userDAO;
	
	public DAOFacadeImpl() {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public UserDAO getUserDAO() {
		return userDAO;
	}

}
