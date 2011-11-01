package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.domain.Domain;

public class Language extends Domain<Long> implements ILanguage {

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

