package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoConnectionImpl;

public abstract class DaoFacade {

	private DaoConnection connection;
	
	public DaoFacade() {
		connection = DaoConnectionImpl.getInstance();
	}
	
	public abstract UserDao getUserDao();
	
}
