package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.Domain;

public final class NullGeo extends Domain<Integer> implements IGeo {

	private static NullGeo instance;
	
	public static NullGeo getInstance() {
		if (instance == null) {
			instance = new NullGeo();
		}
		return instance;
	}
	
	private NullGeo() {}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public IGeoType getType() {
		return NullGeoType.getInstance();
	}

	@Override
	public String getCoordinates() {
		return "";
	}
	
	@Override
	public void save() {}
	
}
