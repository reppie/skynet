package toctep.skynet.backend.dal.domain.geo;

public class NullGeoType implements IGeoType {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
