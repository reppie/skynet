package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.test.SkynetTest;

public class TimeZoneTest extends SkynetTest implements IDomainTest {

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
	
	@Test
	public void testCreate() {
		assertNotNull(timeZone);
		assertEquals("getTimeZone: ", timeZoneString, timeZone.getTimeZone());
		assertEquals("getUtcOffset: ", utcOffset, timeZone.getUtcOffset());
	}

	@Test
	public void testInsert() {
		timeZone.save();
		assertEquals(1, TimeZone.count());
		assertTrue(new Integer(1).equals(timeZone.getId()));
	}
	
	@Test
	public void testSelect() {
		timeZone.save();
		
		ITimeZone postTimeZone = TimeZone.select(timeZone.getId());
		
		assertEquals(postTimeZone.getUtcOffset(), timeZone.getUtcOffset());
		assertTrue(postTimeZone.getTimeZone().equals(timeZone.getTimeZone()));
		
		ITimeZone nullTimeZone = TimeZone.select(1000);
		assertTrue(nullTimeZone instanceof NullTimeZone);
	}

	@Test
	public void testDelete() {
		timeZone.save();
		assertEquals(1, TimeZone.count());
		timeZone.delete();
		assertEquals(0, TimeZone.count());
	}

	@Test
	public void testExists() {
		timeZone.save();
		assertTrue(TimeZone.exists(timeZone));
	}

}
