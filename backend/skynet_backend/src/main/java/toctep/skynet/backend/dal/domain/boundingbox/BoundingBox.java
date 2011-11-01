package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.DomainLongPk;


public class BoundingBox extends DomainLongPk implements IBoundingBox{
	
	private IBoundingBoxType type;
	private String coordinates;
	
	public IBoundingBoxType getType() {
		return type;
	}

	public void setType(IBoundingBoxType type) {
		this.type = type;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public void setDao() {
		dao = daoFacade.getBoundingBoxDao();
	}
	
	@Override
	public void save() {
		if(type instanceof BoundingBoxType) {
			type.save();
			this.type.setId(type.getId());
		}
		super.save();
	}	
}
