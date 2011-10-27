package toctep.skynet.backend.dal.domain;

public class Coordinates extends Domain {
	
	private CoordinatesType type;
	private String coordinates;

	public CoordinatesType getType() {
		return type;
	}

	public void setType(CoordinatesType type) {
		this.type = type;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
}
