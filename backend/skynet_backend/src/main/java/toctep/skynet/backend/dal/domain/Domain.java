package toctep.skynet.backend.dal.domain;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;

public abstract class Domain {
	
	protected DaoFacade daoFacade;
	
	protected Dao dao;
	
	public Domain() {
		daoFacade = new DaoFacadeImpl();
		
		setDao();
	}
	
	public abstract void setDao();
	
	public void save() {
		if (dao.exists(this)) {
			dao.update(this);
		} else {
			dao.insert(this);
		}
	}
	
}
