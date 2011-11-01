package toctep.skynet.backend.dal.domain.hashtag;

import toctep.skynet.backend.dal.domain.Domain;

public class Hashtag extends Domain<Long> implements IHashtag {

	public String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getHashtagDao();
	}
}
