package toctep.skynet.backend.dal.domain;

public class TimeZone {

	private int utcOffset;
	private String timeZone;
	
	public TimeZone(int utcOffset, String timeZone) {
		super();
		this.utcOffset = utcOffset;
		this.timeZone = timeZone;
	}

	public TimeZone() {
		super();
	}

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
