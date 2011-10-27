package toctep.skynet.backend.dal.domain;

public class Language extends Domain {

	public String text;
	
	public Language() {
		super();
	}
	
	public Language(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}

