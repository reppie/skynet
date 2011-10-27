package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetURL;
import toctep.skynet.backend.dal.domain.URL;

public class TweetURLTest extends DomainTest {
	
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
		// TODO Auto-generated method stub
		
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
