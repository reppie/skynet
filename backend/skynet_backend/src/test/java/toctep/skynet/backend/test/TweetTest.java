package toctep.skynet.backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.Tweet;

public class TweetTest extends DomainTest {

	@Test
	public void testCreatingTweet() {
		Tweet tweet = new Tweet();
		assertNotNull(tweet);
		
		String text = "test";
		tweet.setText(text);
		assertTrue(text.equals(tweet.getText()));
		
		boolean truncated = false;
		tweet.setTruncated(truncated);
		assertTrue(truncated == tweet.isTruncated());
	}
	
	@Test
	public void testInsertingTweet() {
		Tweet preTweet = new Tweet();
		
		String text = "test";
		preTweet.setText(text);
		
		tweetDao.insert(preTweet);
		assertEquals(1, tweetDao.count());
		
		Tweet postTweet = (Tweet) tweetDao.select(preTweet.getId());
		assertTrue(postTweet.getText().equals(preTweet.getText()));
		// TODO
	}
	
	@Test
	public void testUpdatingTweet() {
		// TODO
	}
	
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
