package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.DomainStringPk;

public abstract class DaoStringPk extends Dao{
	
	public abstract DomainStringPk select(String id);
	
}