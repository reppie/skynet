package toctep.skynet.backend.dal.domain.timezone;

import toctep.skynet.backend.dal.domain.IDomain;

public interface ITimeZone extends IDomain<Integer> {
	
	int getUtcOffset();
	String getTimeZone();

}
