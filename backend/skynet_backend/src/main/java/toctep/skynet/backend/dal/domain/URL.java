package toctep.skynet.backend.dal.domain;

public class URL {
	
	private String text;
	
	public URL() {
		super();
	}

	public URL(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
