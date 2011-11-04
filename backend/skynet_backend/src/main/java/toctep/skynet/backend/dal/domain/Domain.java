package toctep.skynet.backend.dal.domain;

import toctep.skynet.backend.dal.dao.Dao;

public abstract class Domain<T> implements IDomain<T> {
	
	private boolean dirty;
	
	private T id;
	
	protected Dao<T> dao;
	
	public Domain() {
		setDirty();
		setDao();
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
	
	public abstract void setDao();
	
	public void save() {
		if (isDirty()) {
			if (dao.exists(this)) {
				dao.update(this);			
			} else {
				dao.insert(this);
			}
			clearDirty();
		}
	}
	
	public void delete() {
		dao.delete(this);
	}

}
