package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class PlaceType extends Domain<Long> implements IPlaceType {

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
		dao = DaoFacadeImpl.getInstance().getPlaceTypeDao();
	}
}
