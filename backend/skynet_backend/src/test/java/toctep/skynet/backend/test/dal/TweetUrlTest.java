package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetUrl;
import toctep.skynet.backend.dal.domain.Url;

public class TweetUrlTest extends DomainTest {
	
	@Override
	public void testCreate() {
		TweetUrl tweetURL = new TweetUrl();
		assertNotNull(tweetURL);
		
		Tweet tweet = new Tweet();
		Url url = new Url();
		tweetURL.setTweet(tweet);
		tweetURL.setUrl(url);
		
		assertEquals("getTweet: ", tweet, tweetURL.getTweet());
		assertEquals("getUrl: ", url, tweetURL.getUrl());
	}

	@Override
	public void testInsert() {
		TweetUrl tweetURL = new TweetUrl();
		
		Tweet tweet = new Tweet();
		Url url = new Url();
		tweetURL.setTweet(tweet);
		tweetURL.setUrl(url);
		
		tweetUrlDao.insert(tweet);
		assertEquals(1, tweetUrlDao.count());
		
		TweetUrl postTweetURL = (TweetUrl) tweetUrlDao.select(tweetURL.getId());
		assertTrue(postTweetURL.getTweet().equals(tweetURL.getTweet()));
		assertTrue(postTweetURL.getUrl().equals(tweetURL.getUrl()));
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
		TweetUrl tweetUrl = new TweetUrl();
		assertNotNull(tweetUrl);
		tweetUrlDao.insert(tweetUrl);
		assertEquals(1, tweetUrlDao.count());
		tweetUrlDao.delete(tweetUrl);
		assertEquals(0, tweetUrlDao.count());
	}

}
