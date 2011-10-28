package toctep.skynet.backend.dal.domain;

public class PlaceType extends DomainLongPk {

	public String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
