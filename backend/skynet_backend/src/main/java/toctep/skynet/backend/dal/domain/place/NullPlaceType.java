package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullPlaceType extends NullDomain<Integer> implements IPlaceType {

	private static NullPlaceType instance;
	
	public static NullPlaceType getInstance() {
		if (instance == null) {
			instance = new NullPlaceType();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
