package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBoxType extends Domain<Long> implements IBoundingBoxType {

	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = getDaoFacade().getBoundingBoxTypeDao();		
	}
	
}
