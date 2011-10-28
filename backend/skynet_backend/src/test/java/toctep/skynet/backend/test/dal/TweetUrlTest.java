package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetUrl;
import toctep.skynet.backend.dal.domain.Url;

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
		tweetUrlDao.insert(tweetUrl);
		assertEquals(1, tweetUrlDao.count());
		tweetUrlDao.delete(tweetUrl);
		assertEquals(0, tweetUrlDao.count());
	}

}
