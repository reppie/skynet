package toctep.skynet.backend.dal.domain.timezone;

public class NullTimeZone implements ITimeZone {

	@Override
	public String getId() {
		return "NULL";
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
