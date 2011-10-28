package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetURL;
import toctep.skynet.backend.dal.domain.URL;

public class TweetUrlTest extends DomainTest {
	
	@Override
	public void testCreate() {
		TweetURL tweetURL = new TweetURL();
		assertNotNull(tweetURL);
		
		Tweet tweet = new Tweet();
		URL url = new URL();
		tweetURL.setTweet(tweet);
		tweetURL.setUrl(url);
		
		assertEquals("getTweet: ", tweet, tweetURL.getTweet());
		assertEquals("getUrl: ", url, tweetURL.getUrl());
	}

	@Override
	public void testInsert() {
		TweetURL tweetURL = new TweetURL();
		
		Tweet tweet = new Tweet();
		URL url = new URL();
		tweetURL.setTweet(tweet);
		tweetURL.setUrl(url);
		
		tweetUrlDao.insert(tweet);
		assertEquals(1, tweetUrlDao.count());
		
		TweetURL postTweetURL = (TweetURL) tweetUrlDao.select(tweetURL.getId());
		assertTrue(postTweetURL.getTweet().equals(tweetURL.getTweet()));
		assertTrue(postTweetURL.getUrl().equals(tweetURL.getUrl()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub
		
	}

}
