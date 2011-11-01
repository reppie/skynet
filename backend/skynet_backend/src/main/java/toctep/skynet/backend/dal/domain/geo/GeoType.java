package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class GeoType extends DomainLongPk implements IGeoType {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getGeoTypeDao();	
	}	
}
