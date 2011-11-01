package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class SourceType extends DomainLongPk implements ISourceType {

	public String text;

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
