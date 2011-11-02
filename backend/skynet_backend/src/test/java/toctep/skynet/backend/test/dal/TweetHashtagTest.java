package toctep.skynet.backend.test.dal;

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
