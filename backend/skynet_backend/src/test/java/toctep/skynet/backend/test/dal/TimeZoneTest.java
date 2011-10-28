package toctep.skynet.backend.test.dal;

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
		TimeZone preTimeZone = new TimeZone();
		
		int utcOffset = 0;
		preTimeZone.setUtcOffset(utcOffset);
		
		String timeZone = "test";
		preTimeZone.setTimeZone(timeZone);
		
		timeZoneDao.insert(preTimeZone);
		assertEquals(1, timeZoneDao.count());
		
		TimeZone postTimeZone = (TimeZone) timeZoneDao.select(preTimeZone.getId());
		
		assertEquals(postTimeZone.getUtcOffset(), preTimeZone.getUtcOffset());
		assertTrue(postTimeZone.getTimeZone().equals(preTimeZone.getTimeZone()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		TimeZone timeZone = new TimeZone();
		assertNotNull(timeZone);
		timeZoneDao.insert(timeZone);
		assertEquals(1, timeZoneDao.count());
		timeZoneDao.delete(timeZone);
		assertEquals(0, timeZoneDao.count());
	}

}
