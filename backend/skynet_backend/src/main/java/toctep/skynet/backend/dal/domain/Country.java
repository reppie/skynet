package toctep.skynet.backend.dal.domain;

public class Country extends DomainStringPk {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
