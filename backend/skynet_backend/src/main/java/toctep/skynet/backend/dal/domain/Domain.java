package toctep.skynet.backend.dal.domain;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;

public abstract class Domain<T> {
	
	private T id;
	
	protected DaoFacade daoFacade;
	protected Dao<T> dao;
	
	public Domain() {
		daoFacade = new DaoFacadeImpl();
		
		setDao();
	}
	
	public T getId() {
		return id;
	}
	
	public void setId(T id) { 
		this.id = id;
	}
	
	public void save() {
		if (dao.exists(this)) {
			dao.update(this);
		} else {
			dao.insert(this);
		}
	}
	
	public void delete() {
		dao.delete(this);
	}
	
	public abstract void setDao();
}
