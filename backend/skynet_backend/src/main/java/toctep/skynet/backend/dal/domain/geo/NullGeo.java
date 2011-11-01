package toctep.skynet.backend.dal.domain.geo;

public class NullGeo implements IGeo {

	@Override
	public IGeoType getType() {
		return new NullGeoType();
	}

	@Override
	public String getCoordinates() {
		return "";
	}

}
