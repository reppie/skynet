package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Hashtag;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetHashtag;

public class TweetHashtagTest extends DomainTest {

	private TweetHashtag tweetHashtag;
	
	private Tweet tweet;
	private Hashtag hashtag;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetHashtag = new TweetHashtag();
		
		tweet = new Tweet();
		tweetHashtag.setTweet(tweet);
		
		hashtag = new Hashtag();
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
		tweetHashtagDao.insert(tweetHashtag);
		assertEquals(1, boundingBoxDao.count());
	}
	
	@Override
	public void testSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		tweetHashtagDao.insert(tweetHashtag);
		assertEquals(1, tweetHashtagDao.count());
		tweetHashtagDao.delete(tweetHashtag);
		assertEquals(0, tweetHashtagDao.count());
	}
	

}
