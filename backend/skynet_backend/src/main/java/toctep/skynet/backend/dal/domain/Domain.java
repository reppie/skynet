package toctep.skynet.backend.dal.domain;

import toctep.skynet.backend.dal.dao.Dao;

public abstract class Domain<T> implements IDomain<T> {
	
	private T id;
	
	protected Dao<T> dao;
	
	public Domain() {
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
