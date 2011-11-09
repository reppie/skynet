package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.hashtag.IHashtag;
import toctep.skynet.backend.dal.domain.hashtag.NullHashtag;
import toctep.skynet.backend.test.SkynetTest;

public class HashtagTest extends SkynetTest implements IDomainTest {

	private Hashtag hashtag;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		hashtag = new Hashtag();
		
		text = "toctep";
		hashtag.setText(text);
	}
	
	@Test
	public void testCreate() { 
		assertNotNull(hashtag);
		assertTrue(text.equals(hashtag.getText()));
	}

	@Test
	public void testInsert() {
		hashtag.save();
		assertEquals(1, Hashtag.count());
		assertTrue(new Integer(1).equals(hashtag.getId()));
	}
	
	@Test
	public void testSelect() {
		hashtag.save();
		
		IHashtag postHashtag = Hashtag.select(hashtag.getId());
		
		assertTrue(postHashtag.getText().equals(hashtag.getText()));
		
		IHashtag nullHashtag = Hashtag.select(1000);
		assertTrue(nullHashtag instanceof NullHashtag);
	}
	
	@Test
	public void testDelete() {
		hashtag.save();
		assertEquals(1, Hashtag.count());
		hashtag.delete();
		assertEquals(0, Hashtag.count());	
	}

	@Test
	public void testExists() {
		hashtag.save();
		assertTrue(Hashtag.exists(hashtag));
	}

}
