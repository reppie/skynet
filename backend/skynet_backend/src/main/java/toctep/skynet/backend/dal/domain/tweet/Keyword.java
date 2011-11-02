package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;

public class Keyword extends Domain<Long> implements IKeyword {
	
	private String keyword = "";
	
	public Keyword() {
		super();
	}
	
	public Keyword(String keyword) {
		super();
		this.keyword = keyword.toLowerCase();
	}
	
	@Override
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public void setDao() {
		dao = getDaoFacade().getKeywordDao();
	}
}
