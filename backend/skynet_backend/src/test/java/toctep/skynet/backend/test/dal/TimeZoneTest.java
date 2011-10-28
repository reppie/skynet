package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.TimeZone;

public class TimeZoneTest extends DomainTest {

	private TimeZone timeZone;
	
	private String timeZoneString;
	private int utcOffset;
	
	@Override
	public void setUp() {
		super.setUp();
		
		timeZone = new TimeZone();
		
		timeZoneString = "GMT";
		timeZone.setTimeZone(timeZoneString);
		
		utcOffset = 2;
		timeZone.setUtcOffset(utcOffset);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(timeZone);
		assertEquals("getTimeZone: ", timeZoneString, timeZone.getTimeZone());
		assertEquals("getUtcOffset: ", utcOffset, timeZone.getUtcOffset());
	}

	@Override
	public void testInsert() {
		timeZoneDao.insert(timeZone);
		assertEquals(1, timeZoneDao.count());
		assertEquals(1, timeZone.getId());
	}
	
	@Override
	public void testSelect() {
		timeZoneDao.insert(timeZone);
		
		TimeZone postTimeZone = (TimeZone) timeZoneDao.select(timeZone.getId());
		
		assertEquals(postTimeZone.getUtcOffset(), timeZone.getUtcOffset());
		assertTrue(postTimeZone.getTimeZone().equals(timeZone.getTimeZone()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		timeZoneDao.insert(timeZone);
		assertEquals(1, timeZoneDao.count());
		timeZoneDao.delete(timeZone);
		assertEquals(0, timeZoneDao.count());
	}

}
