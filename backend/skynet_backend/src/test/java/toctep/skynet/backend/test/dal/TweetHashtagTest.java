package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;
import toctep.skynet.backend.test.SkynetTest;

public class TweetHashtagTest extends SkynetTest implements IDomainTest {

	private TweetHashtag tweetHashtag;
	
	private Tweet tweet;
	private Hashtag hashtag;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetHashtag = new TweetHashtag();
		
		tweet = new Tweet();
		tweet.setId(new Long(1));
		tweetHashtag.setTweet(tweet);
		
		hashtag = new Hashtag();
		hashtag.setId(1);
		tweetHashtag.setHashtag(hashtag);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(tweetHashtag);
		assertEquals("getHashtag: ", hashtag, tweetHashtag.getHashtag());
		assertEquals("getTweet: ", tweet, tweetHashtag.getTweet());
	}

	@Test
	public void testInsert() {
		tweetHashtag.save();
		assertEquals(1, TweetHashtag.count());
	}
	
	@Test
	public void testSelect() {
		tweetHashtag.save();

		TweetHashtag postTweetHashtag = TweetHashtag.select(tweetHashtag.getId());

		assertTrue(postTweetHashtag.getTweet().getId().equals(tweetHashtag.getTweet().getId()));
		assertTrue(postTweetHashtag.getHashtag().getId().equals(tweetHashtag.getHashtag().getId()));		
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		Hashtag hashtag = new Hashtag();
		hashtag.setId(1);
		hashtag.save();
		
		tweet.addHashtag(hashtag);
		
		tweet.save();
		
		assertEquals(1, tweet.getHashtags().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getHashtags().size());
	}
	
	@Test
	public void testSelectFromTweetWithNullHashtag() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		Hashtag hashtag = new Hashtag();
		hashtag.setId(1);
		
		tweet.addHashtag(hashtag);
		
		tweet.save();
		
		assertEquals(1, tweet.getHashtags().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getHashtags().size());
	}	

	@Test
	public void testDelete() {
		tweetHashtag.save();
		assertEquals(1, TweetHashtag.count());
		tweetHashtag.delete();
		assertEquals(0, TweetHashtag.count());
	}

	@Test
	public void testExists() {
		tweetHashtag.save();
		assertTrue(TweetHashtag.exists(tweetHashtag));
		assertTrue(TweetHashtag.exists(tweetHashtag.getId()));
	}

}
