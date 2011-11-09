package toctep.skynet.backend.dal.domain.country;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullCountry extends NullDomain<String> implements ICountry {

	private static NullCountry instance;
	
	public static NullCountry getInstance() {
		if (instance == null) {
			instance = new NullCountry();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
