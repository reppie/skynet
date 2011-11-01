package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class TimeZone extends DomainLongPk implements ITimeZone{

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

	@Override
	public void setDao() {
		dao = daoFacade.getTimeZoneDao();
	}
}
