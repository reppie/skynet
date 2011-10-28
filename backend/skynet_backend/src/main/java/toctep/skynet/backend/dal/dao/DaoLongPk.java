package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public abstract class DaoLongPk extends Dao{
	
	public abstract DomainLongPk select(long id);
	
}
