package toctep.skynet.backend.dal.domain;

public class TimeZone extends DomainLongPk {

	private int utcOffset;
	private String timeZone;

	public int getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
}
