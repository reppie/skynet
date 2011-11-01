package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class PlaceType extends DomainLongPk {

	public String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getPlaceTypeDao();
	}
}
