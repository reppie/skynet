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
		
		tweetUrl = new TweetUrl();
		
		tweet = new Tweet();
		tweet.setId(new Long(0));
				
		url = new Url();
		url.setId("Test");
		
		tweetUrl.setUrl(url);
		tweetUrl.setTweet(tweet);
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
		tweetUrl.save();
		
		TweetUrl postTweetUrl = (TweetUrl) tweetUrlDao.select(tweetUrl.getId());
		
		assertTrue(postTweetUrl.getTweet().getId().equals(tweetUrl.getTweet().getId()));
		assertTrue(postTweetUrl.getUrl().getId().equals(tweetUrl.getUrl().getId()));	
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
