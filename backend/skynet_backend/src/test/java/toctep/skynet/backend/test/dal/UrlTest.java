package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.test.SkynetTest;

public class UrlTest extends SkynetTest implements IDomainTest {
	
	private Url url;
	
	@Override
	public void setUp() {
		super.setUp();
		
		url = new Url();
		url.setId("url://");
	}
	
	@Test
	public void testCreate() {
		assertNotNull(url);
	}

	@Test
	public void testInsert() {
		url.save();
		assertEquals(1, Url.count());
	}
	
	@Test
	public void testSelect() {
		url.save();
		assertEquals(1, Url.count());
		
		IUrl postUrl = Url.select(url.getId());
		assertTrue(postUrl.getId().equals(url.getId()));
	}

	@Test
	public void testDelete() {
		url.save();
		assertEquals(1, Url.count());
		url.delete();
		assertEquals(0, Url.count());
	}

	@Test
	public void testExists() {
		url.save();
		assertTrue(Url.exists(url));
	}

}

