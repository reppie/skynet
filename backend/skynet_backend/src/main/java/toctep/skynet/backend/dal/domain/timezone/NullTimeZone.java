package toctep.skynet.backend.dal.domain.timezone;

public final class NullTimeZone implements ITimeZone {

	private static NullTimeZone instance;
	
	public static NullTimeZone getInstance() {
		if (instance == null) {
			instance = new NullTimeZone();
		}
		return instance;
	}
	
	private NullTimeZone() { }
	
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
	
}
