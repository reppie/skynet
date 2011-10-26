package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.UserDao;

public class DaoFacadeImpl implements DaoFacade {
	
	private UserDao userDAO;
	
	public DaoFacadeImpl() {
		userDAO = new UserDaoImpl();
	}
	
	@Override
	public UserDao getUserDAO() {
		return userDAO;
	}

}
