package toctep.skynet.backend.dal.domain.geo;

public class NullGeoType implements IGeoType {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
