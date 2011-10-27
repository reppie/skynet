package toctep.skynet.backend.dal.domain;

public class Geo {
	
	private GeoType type;
	private String coordinates;
	
	public Geo(){		
	}
	
	public Geo(GeoType type, String coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}	

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
