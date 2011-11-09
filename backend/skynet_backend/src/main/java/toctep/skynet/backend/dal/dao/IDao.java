package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Domain;

public interface IDao<T> {
	
	void insert(Domain<T> domain);
	Domain<T> select(T id);
	void delete(Domain<T> domain);
		
	boolean exists(Domain<T> domain);
	boolean exists(T id);
	
	int count();
	
}
