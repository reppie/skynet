package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullTimeZone extends NullDomain implements ITimeZone {

	private static NullTimeZone instance;
	
	public static NullTimeZone getInstance() {
		if (instance == null) {
			instance = new NullTimeZone();
		}
		return instance;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getTimeZone() {
		return "";
	}

	@Override
	public int getUtcOffset() {
		return 0;
	}

	@Override
	public void save() {}
	
}
