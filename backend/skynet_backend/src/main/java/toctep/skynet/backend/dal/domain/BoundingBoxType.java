package toctep.skynet.backend.dal.domain;

public class BoundingBoxType {

	private String text;
	
	public BoundingBoxType() {		
	}
	
	public BoundingBoxType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
