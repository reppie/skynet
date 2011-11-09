package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullGeo extends NullDomain<Integer> implements IGeo {

	private static NullGeo instance;
	
	public static NullGeo getInstance() {
		if (instance == null) {
			instance = new NullGeo();
		}
		return instance;
	}
	
	@Override
	public IGeoType getType() {
		return NullGeoType.getInstance();
	}

	@Override
	public String getCoordinates() {
		return "";
	}
	
}
