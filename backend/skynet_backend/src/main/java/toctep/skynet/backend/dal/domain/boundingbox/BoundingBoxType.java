package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class BoundingBoxType extends DomainLongPk implements IBoundingBoxType {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getBoundingBoxTypeDao();		
	}
	
}
