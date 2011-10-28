package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Hashtag;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetHashtag;

public class TweetHashtagTest extends DomainTest {

	@Override
	public void testCreate() {
		TweetHashtag tweetHashtag = new TweetHashtag();
		assertNotNull(tweetHashtag);
		
		Tweet tweet = new Tweet();
		Hashtag hashtag = new Hashtag();
		tweetHashtag.setHashtag(hashtag);
		tweetHashtag.setTweet(tweet);
		
		assertEquals("getHashtag: ", hashtag, tweetHashtag.getHashtag());
		assertEquals("getTweet: ", tweet, tweetHashtag.getTweet());
	}

	@Override
	public void testInsert() {
		TweetHashtag preTweetHashtag = new TweetHashtag();
		
		Tweet tweet = new Tweet();
		preTweetHashtag.setTweet(tweet);
		
		Hashtag hashtag = new Hashtag();
		preTweetHashtag.setHashtag(hashtag);
		
		tweetHashtagDao.insert(preTweetHashtag);
		assertEquals(1, boundingBoxDao.count());
		
		TweetHashtag postTweetHastag = (TweetHashtag) tweetHashtagDao.select(preTweetHashtag.getId());
		
		assertTrue(postTweetHastag.getHashtag().equals(preTweetHashtag.getHashtag()));
		assertTrue(postTweetHastag.getTweet().equals(preTweetHashtag.getTweet()));
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
		TweetHashtag tweetHashtag = new TweetHashtag();
		assertNotNull(tweetHashtag);
		tweetHashtagDao.insert(tweetHashtag);
		assertEquals(1, tweetHashtagDao.count());
		tweetHashtagDao.delete(tweetHashtag);
		assertEquals(0, tweetHashtagDao.count());
	}
	

}
