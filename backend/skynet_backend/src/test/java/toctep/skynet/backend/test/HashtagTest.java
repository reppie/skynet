package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Hashtag;

public class HashtagTest extends DomainTest{

	@Override
	public void testCreate() { 
		Hashtag hashtag = new Hashtag();
		assertNotNull(hashtag);
		
		String text = "toctep";
		hashtag.setText(text);
		assertTrue(text.equals(hashtag.getText()));
	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
