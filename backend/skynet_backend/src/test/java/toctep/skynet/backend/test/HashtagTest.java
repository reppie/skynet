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
		Hashtag hashtag = new Hashtag();
		assertNotNull(hashtag);
		hashtagDao.insert(hashtag);
		assertEquals(1, hashtagDao.count());
		hashtagDao.delete(hashtag);
		assertEquals(0, hashtagDao.count());		
	}

	@Override
	public void testInsert() {
		Hashtag preHashtag = new Hashtag();
		
		String text = "Test";
		preHashtag.setText(text);
		
		hashtagDao.insert(preHashtag);
		assertEquals(1, hashtagDao.count());
		
		Hashtag postHashtag = (Hashtag) hashtagDao.select(preHashtag.getId());
		assertTrue(postHashtag.getText().equals(preHashtag.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
