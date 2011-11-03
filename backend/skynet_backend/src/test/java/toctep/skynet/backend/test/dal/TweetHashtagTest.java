package toctep.skynet.backend.test.dal;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;

public class TweetHashtagTest extends DomainTest {

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
	
	@Override
	public void testCreate() {
		assertNotNull(tweetHashtag);
		assertEquals("getHashtag: ", hashtag, tweetHashtag.getHashtag());
		assertEquals("getTweet: ", tweet, tweetHashtag.getTweet());
	}

	@Override
	public void testInsert() {
		tweetHashtag.save();
		assertEquals(1, tweetHashtagDao.count());
	}
	
	@Override
	public void testSelect() {
		tweetHashtag.save();
		
		TweetHashtag postTweetHashtag = (TweetHashtag) tweetHashtagDao.select(tweetHashtag.getId());
		
		assertTrue(postTweetHashtag.getTweet().getId().equals(tweetHashtag.getTweet().getId()));
		assertTrue(postTweetHashtag.getHashtag().getId().equals(tweetHashtag.getHashtag().getId()));		
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		Hashtag hashtag = new Hashtag();
		hashtag.setId(1);
		
		TweetHashtag tweetHashtag = new TweetHashtag();
		tweetHashtag.setTweet(tweet);
		tweetHashtag.setHashtag(hashtag);
		
		tweet.addHashtag(tweetHashtag);
		
		tweet.save();
		
		assertEquals(1, tweet.getHashtags().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getHashtags().size());
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		tweetHashtag.save();
		assertEquals(1, tweetHashtagDao.count());
		tweetHashtag.delete();
		assertEquals(0, tweetHashtagDao.count());
	}
	

}
