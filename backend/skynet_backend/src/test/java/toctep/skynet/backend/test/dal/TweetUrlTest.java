package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class TweetUrlTest extends DomainTest {
	
	private TweetUrl tweetUrl;
	
	private Tweet tweet;
	private Url url;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweet = new Tweet();
		tweetUrl.setTweet(tweet);
		
		url = new Url();
		tweetUrl.setUrl(url);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(tweetUrl);
		assertEquals("getTweet: ", tweet, tweetUrl.getTweet());
		assertEquals("getUrl: ", url, tweetUrl.getUrl());
	}

	@Override
	public void testInsert() {
		tweetUrl.save();
		assertEquals(1, tweetUrlDao.count());
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
		tweetUrl.save();
		assertEquals(1, tweetUrlDao.count());
		tweetUrl.delete();
		assertEquals(0, tweetUrlDao.count());
	}

}
