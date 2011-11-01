package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class Language extends DomainLongPk implements ILanguage {

	public String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getLanguageDao();
	}
}

