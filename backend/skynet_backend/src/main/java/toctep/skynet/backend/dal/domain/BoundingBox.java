package toctep.skynet.backend.dal.domain;


public class BoundingBox extends DomainLongPk {
	
	private BoundingBoxType type;
	private String coordinates;
	
	public BoundingBoxType getType() {
		return type;
	}

	public void setType(BoundingBoxType type) {
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
	
}
