package toctep.skynet.backend.dal.domain;

public class Language extends DomainLongPk {

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

