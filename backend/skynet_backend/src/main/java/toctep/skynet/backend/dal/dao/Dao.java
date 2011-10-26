package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Domain;

public interface Dao {

	public abstract void insert(Domain domain);
	public abstract Domain select(int id);
	public abstract void update(Domain domain);
	public abstract void delete(Domain domain);
	
}
