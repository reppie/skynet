package toctep.skynet.backend.dal.domain;

public class Country extends Domain {

	private String code;
	private String text;
	
	public Country() {
		super();
	}
	
	public Country(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
