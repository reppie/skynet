package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Domain;

public abstract class Dao {
	
	protected String tableName;
	
	public Dao() {
		setTableName();
	}
	
	protected abstract void setTableName();
	
	public abstract void insert(Domain domain);
	public abstract void update(Domain domain);
	public abstract void delete(Domain domain);
		
	public abstract boolean exists(Domain domain);
	public abstract int count();
	
}
