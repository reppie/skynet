package toctep.skynet.backend.dal.domain;

public class BoundingBox {
	
	private BoundingBoxType type;
	private String coordinates;
	
	public BoundingBox(BoundingBoxType type, String coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

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
	
}
