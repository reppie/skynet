package toctep.skynet.backend.dal.domain;

public class Hashtag extends Domain {

	public String text;
	
	public Hashtag() {
		super();
	}
	
	public Hashtag(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
