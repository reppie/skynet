package toctep.skynet.backend.dal.domain.geo;

public class NullGeo implements IGeo {

	@Override
	public Long getId() {
		return 0L;
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
