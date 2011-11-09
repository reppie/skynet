package toctep.skynet.backend.dal.domain;

public abstract class NullDomain<T> {

	protected NullDomain() {}
	
	public T getId() {
		return null;
	}
	
	public void save() {}
	
}
