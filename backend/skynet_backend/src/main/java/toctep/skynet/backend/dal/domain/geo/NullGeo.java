package toctep.skynet.backend.dal.domain.geo;

public class NullGeo implements IGeo {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public IGeoType getType() {
		return new NullGeoType();
	}

	@Override
	public String getCoordinates() {
		return "";
	}

}
