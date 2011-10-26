package toctep.skynet.backend.dal.domain;

public abstract class Domain {

	private int id;
	
	public Domain(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) { 
		this.id = id;
	}
	
}
