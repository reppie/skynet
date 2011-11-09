package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Domain;

public abstract class Dao<T> {
	
	public abstract void insert(Domain<T> domain);
	public abstract Domain<T> select(T id);
	public abstract void delete(Domain<T> domain);
		
	public abstract boolean exists(Domain<T> domain);
	public abstract boolean exists(T id);
	
	public abstract int count();
	
}
