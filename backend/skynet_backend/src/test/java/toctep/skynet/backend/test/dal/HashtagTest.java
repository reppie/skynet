package toctep.skynet.backend.test.dal;

import static org.junit.Assert.*;

import toctep.skynet.backend.dal.domain.hashtag.Hashtag;

public class HashtagTest extends DomainTest {

	private Hashtag hashtag;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		hashtag = new Hashtag();
		
		text = "toctep";
		hashtag.setText(text);
	}
	
	@Override
	public void testCreate() { 
		assertNotNull(hashtag);
		assertTrue(text.equals(hashtag.getText()));
	}

	@Override
	public void testInsert() {
		hashtag.save();
		assertEquals(1, hashtagDao.count());
		assertTrue(new Integer(1).equals(hashtag.getId()));
	}
	
	@Override
	public void testSelect() {
		hashtag.save();
		
		Hashtag postHashtag = (Hashtag) hashtagDao.select(hashtag.getId());
		
		assertTrue(postHashtag.getText().equals(hashtag.getText()));
	}
	
	@Override
	public void testDelete() {
		hashtag.save();
		assertEquals(1, hashtagDao.count());
		hashtag.delete();
		assertEquals(0, hashtagDao.count());	
	}

	@Override
	public void testExists() {
		hashtag.save();
		assertTrue(hashtagDao.exists(hashtag));
	}

}
