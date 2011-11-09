package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullPlaceType extends NullDomain implements IPlaceType {

	private static NullPlaceType instance;
	
	public static NullPlaceType getInstance() {
		if (instance == null) {
			instance = new NullPlaceType();
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
