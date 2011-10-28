package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Url;

public class UrlTest extends DomainTest {
	
	@Override
	public void testCreate() {
		Url url = new Url();
		assertNotNull(url);
		assertNull(url.getId());
		
		String urlText = "htt://www.diablo3.com";
		url.setId(urlText);
		assertEquals("getText result: ", urlText, url.getId());
	}

	@Override
	public void testInsert() {
		Url preURL = new Url();
		
		String urlText = "http://www.diablo3.com";
		preURL.setId(urlText);
		
		urlDao.insert(preURL);
		assertEquals(1, urlDao.count());
		
		Url postURL = (Url) urlDao.select(preURL.getId());
		assertTrue(postURL.getId().equals(preURL.getId()));
	}
	
	@Override
	public void testSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		Url url = new Url();
		assertNotNull(url);
		urlDao.insert(url);
		assertEquals(1, urlDao.count());
		urlDao.delete(url);
		assertEquals(0, urlDao.count());
	}

}

