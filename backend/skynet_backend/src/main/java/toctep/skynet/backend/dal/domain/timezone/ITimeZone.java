package toctep.skynet.backend.dal.domain.timezone;

public interface ITimeZone {
	public int getUtcOffset();
	public String getTimeZone();
}
