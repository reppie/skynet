package toctep.skynet.backend.test.dal;

import static org.junit.Assert.*;

import toctep.skynet.backend.dal.domain.url.Url;

public class UrlTest extends DomainTest {
	
	private Url url;
	
	@Override
	public void setUp() {
		super.setUp();
		
		url = new Url();
		url.setId("url://");
	}
	
	@Override
	public void testCreate() {
		assertNotNull(url);
	}

	@Override
	public void testInsert() {
		url.save();
		assertEquals(1, urlDao.count());
	}
	
	@Override
	public void testSelect() {
		url.save();
		assertEquals(1, urlDao.count());
		
		Url postUrl = (Url) urlDao.select(url.getId());
		assertTrue(postUrl.getId().equals(url.getId()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		url.save();
		assertEquals(1, urlDao.count());
		url.delete();
		assertEquals(0, urlDao.count());
	}

	@Override
	public void testExists() {
		url.save();
		assertTrue(urlDao.exists(url));
	}

}

