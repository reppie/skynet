package toctep.skynet.backend.dal.domain;

public class Coordinates {
	
	private CoordinatesType type;
	private String coordinates;
	
	public Coordinates(){		
	}
	
	public Coordinates(CoordinatesType type, String coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}	

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
