package toctep.skynet.backend.dal.domain;

import toctep.skynet.backend.dal.dao.Dao;

public abstract class Domain<T> implements IDomain<T> {
	
	private boolean dirty;
		
	private Dao<T> dao;
	
	private T id;
	
	public Domain() {
		setDirty();
	}
	
	public final boolean isDirty() {
		return dirty;
	}
	
	public final void setDirty() {
		dirty = true;
	}
	
	public final void clearDirty() {
		dirty = false;
	}
	
	public T getId() {
		return id;
	}
	
	public void setId(T id) {
		this.id = id;
	}
	
	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}
	
	public Dao<T> getDao() {
		return dao;
	}
	
	public void save() {
		if (isDirty()) {
			if (!dao.exists(this)) {
				dao.insert(this);			
			}
			clearDirty();
		}
	}
	
	public void delete() {
		dao.delete(this);
	}

}
