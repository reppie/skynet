package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class Keyword extends DomainLongPk {
	
	private String keyword;
	
	public Keyword() {
		super();
	}
	
	public Keyword(String keyword) {
		super();
		this.keyword = keyword.toLowerCase();
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getKeywordDao();
	}
}
