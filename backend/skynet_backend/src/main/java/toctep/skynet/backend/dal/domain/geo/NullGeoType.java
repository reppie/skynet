package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullGeoType extends NullDomain<Integer> implements IGeoType {

	private static NullGeoType instance;
	
	public static NullGeoType getInstance() {
		if (instance == null) {
			instance = new NullGeoType();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
