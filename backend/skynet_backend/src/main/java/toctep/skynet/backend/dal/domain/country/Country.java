package toctep.skynet.backend.dal.domain.country;

import toctep.skynet.backend.dal.domain.Domain;

public class Country extends Domain<String> implements ICountry {

	private String text = "";

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