package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Url;

public class UrlTest extends DomainTest {
	
	@Override
	public void testCreate() {
		Url url = new Url();
		assertNotNull(url);
		assertNull(url.getText());
		
		String urlText = "htt://www.diablo3.com";
		url.setText(urlText);
		assertEquals("getText result: ", urlText, url.getText());
	}

	@Override
	public void testInsert() {
		Url preURL = new Url();
		
		String urlText = "http://www.diablo3.com";
		preURL.setText(urlText);
		
		urlDao.insert(preURL);
		assertEquals(1, urlDao.count());
		
		Url postURL = (Url) urlDao.select(preURL.getId());
		assertTrue(postURL.getText().equals(preURL.getText()));
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

