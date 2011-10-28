package toctep.skynet.backend.dal.domain;

public class BoundingBoxType extends DomainLongPk {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
