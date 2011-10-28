package toctep.skynet.backend.dal.domain;

public abstract class DomainLongPk extends Domain{

	private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) { 
		this.id = id;
	}
	
}
