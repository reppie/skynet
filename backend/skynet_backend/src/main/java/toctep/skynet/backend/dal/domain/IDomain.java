package toctep.skynet.backend.dal.domain;

public interface IDomain<T> {
	
	T getId();
	void save();
	
}
