package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.IDomain;

public interface ITimeZone extends IDomain<Long> {
	
	public int getUtcOffset();
	public String getTimeZone();

}
