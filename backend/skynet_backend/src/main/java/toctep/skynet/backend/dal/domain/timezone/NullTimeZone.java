package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullTimeZone extends NullDomain<Integer> implements ITimeZone {

	private static NullTimeZone instance;
	
	public static NullTimeZone getInstance() {
		if (instance == null) {
			instance = new NullTimeZone();
		}
		return instance;
	}
	
	@Override
	public String getTimeZone() {
		return "";
	}

	@Override
	public int getUtcOffset() {
		return 0;
	}
	
}
