package toctep.skynet.backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.Tweet;

public class TweetTest extends DomainTest {

	@Test
	public void testAddingTweet() {
		Tweet preTweet = new Tweet();
		assertNotNull(preTweet);
		
		String text = "Lap text";
		preTweet.setText(text);
		assertTrue(text.equals(preTweet.getText()));
		
		tweetDao.insert(preTweet);
		assertEquals(1, tweetDao.count());
		Tweet postTweet = (Tweet) tweetDao.select(preTweet.getId());
		assertTrue(postTweet.getText().equals(preTweet.getText()));
	}
	
	//@Test
	//public void testUpdatingUser() {
	//	
	//}
	
	@Test
	public void testDeletingTweet() {
		Tweet tweet = new Tweet();
		assertNotNull(tweet);
		tweetDao.insert(tweet);
		assertEquals(1, tweetDao.count());
		tweetDao.delete(tweet);
		assertEquals(0, tweetDao.count());
	}

}
