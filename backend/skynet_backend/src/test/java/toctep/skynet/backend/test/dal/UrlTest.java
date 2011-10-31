package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Url;

public class UrlTest extends DomainTest {
	
	private Url url;
	
	@Override
	public void setUp() {
		super.setUp();
		
		url = new Url();
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

}

