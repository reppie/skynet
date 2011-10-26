package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Domain;

public interface Dao {

	public void insert(Domain domain);
	public Domain select(int id);
	public void update(Domain domain);
	public void delete(Domain domain);
	
}
