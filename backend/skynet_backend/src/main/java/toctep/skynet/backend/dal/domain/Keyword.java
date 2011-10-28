package toctep.skynet.backend.dal.domain;

public class Keyword extends Domain {
	
	private int keywordId;
	private String keyword;
	
	public int getKeywordId() {
		return keywordId;
	}
	
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
