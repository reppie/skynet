package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.TimeZone;

public class TimeZoneTest extends DomainTest {

	@Override
	public void testCreate() {
		TimeZone timeZone = new TimeZone();
		assertNotNull(timeZone);
		
		String timeZoneString = "GMT";
		int utcOffset = 2;
		timeZone.setTimeZone(timeZoneString);
		timeZone.setUtcOffset(utcOffset);
		assertEquals("getTimeZone: ", timeZoneString, timeZone.getTimeZone());
		assertEquals("getUtcOffset: ", utcOffset, timeZone.getUtcOffset());
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub
		
	}

}
