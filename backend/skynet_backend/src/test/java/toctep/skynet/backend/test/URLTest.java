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
