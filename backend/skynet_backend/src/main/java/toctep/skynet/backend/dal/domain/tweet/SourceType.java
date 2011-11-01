package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;

public class SourceType extends Domain<Long> implements ISourceType {

	public String text = "";

	@Override
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getSourceTypeDao();
	}
	
}
