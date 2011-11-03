package toctep.skynet.backend.dal.domain.geo;

public final class NullGeoType implements IGeoType {

	private static NullGeoType instance;
	
	public static NullGeoType getInstance() {
		if (instance == null) {
			instance = new NullGeoType();
		}
		return instance;
	}
	
	private NullGeoType() { }	
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
