package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.URL;

public class URLTest extends DomainTest {
	
	@Override
	public void testCreate() {
		URL url = new URL();
		assertNotNull(url);
		assertNull(url.getText());
		
		String urlText = "htt://www.diablo3.com";
		url.setText(urlText);
		assertEquals("getText result: ", urlText, url.getText());
	}

	@Override
	public void testInsert() {
		URL preURL = new URL();
		
		String urlText = "http://www.diablo3.com";
		preURL.setText(urlText);
		
		urlDao.insert(preURL);
		assertEquals(1, urlDao.count());
		
		URL postURL = (URL) urlDao.select(preURL.getId());
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

