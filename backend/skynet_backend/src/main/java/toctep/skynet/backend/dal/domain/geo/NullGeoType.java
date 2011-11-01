package toctep.skynet.backend.dal.domain.geo;

public class NullGeoType implements IGeoType {

	@Override
	public Long getId() {
		return 0L;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
