package toctep.skynet.backend.dal.domain;

public class Geo extends Domain {
	
	private GeoType type;
	private String coordinates;

	public GeoType getType() {
		return type;
	}

	public void setType(GeoType type) {
		this.type = type;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
}
