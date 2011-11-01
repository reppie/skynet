package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBox extends Domain<Long> implements IBoundingBox<Long> {
	
	private IBoundingBoxType<Long> type;
	private String coordinates;
	
	public IBoundingBoxType<Long> getType() {
		return type;
	}

	public void setType(IBoundingBoxType<Long> type) {
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
			((BoundingBoxType) type).save();
			((BoundingBoxType) this.type).setId(((BoundingBoxType) type).getId());
		}
		
		super.save();
	}	
}
