package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullGeoType extends NullDomain implements IGeoType {

	private static NullGeoType instance;
	
	public static NullGeoType getInstance() {
		if (instance == null) {
			instance = new NullGeoType();
		}
		return instance;
	}	
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
	@Override
	public void save() {}
	
}
