package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoConnectionImpl;
import toctep.skynet.backend.dal.domain.Domain;

public abstract class Dao {

	private Object connection;
	
	public Dao() {
		connection = DaoConnectionImpl.getInstance().getConnection();
	}
	
	public abstract void insert(Domain domain);
	public abstract Domain select(int id);
	public abstract void update(Domain domain);
	public abstract void delete(Domain domain);
	
	protected Object getConnection() {
		return connection;
	}
}
