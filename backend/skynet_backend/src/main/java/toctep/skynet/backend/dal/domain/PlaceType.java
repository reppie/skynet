package toctep.skynet.backend.dal.domain;

public class PlaceType extends Domain {

	public String text;
	
	public PlaceType(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
