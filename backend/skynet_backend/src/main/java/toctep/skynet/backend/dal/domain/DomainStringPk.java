package toctep.skynet.backend.dal.domain;

public abstract class DomainStringPk extends Domain{

	private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) { 
		this.id = id;
	}
	
}
