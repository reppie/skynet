package toctep.skynet.backend.dal.domain.timezone;

public class NullTimeZone implements ITimeZone {

	@Override
	public Long getId() {
		return 0L;
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
