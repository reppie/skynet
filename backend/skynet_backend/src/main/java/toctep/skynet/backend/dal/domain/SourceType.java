package toctep.skynet.backend.dal.domain;

public class SourceType extends Domain {

	public String text;
	
	public SourceType(String text) {
		this.text = text;
	}
	
	public SourceType() {
		super();
	}

	public String getSourceType() {
		return text;
	}
	
	public void setSourceType(String text) {
		this.text = text;
	}
	
}
