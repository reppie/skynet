package toctep.skynet.backend.dal.domain.country;

import toctep.skynet.backend.dal.domain.DomainStringPk;

public class Country extends DomainStringPk implements ICountry {

	private String text;

	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getCountryDao();		
	}
	
}
