package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class TimeZone extends Domain<Long> implements ITimeZone{

	private int utcOffset 	= 0;
	private String timeZone = "";

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
		dao = DaoFacadeImpl.getInstance().getTimeZoneDao();
	}
	
	public static ITimeZone select(Long id) {
		TimeZoneDao dao = DaoFacadeImpl.getInstance().getTimeZoneDao();
		
		if (dao.exists(id)) {
			return (TimeZone) dao.select(id);
		}
		
		return NullTimeZone.getInstance();
	}
	
}
