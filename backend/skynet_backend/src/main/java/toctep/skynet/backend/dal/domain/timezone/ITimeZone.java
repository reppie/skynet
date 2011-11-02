package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.IDomain;

public interface ITimeZone extends IDomain<Long> {
	
	int getUtcOffset();
	String getTimeZone();

}
