package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.test.SkynetTest;

public class TweetUrlTest extends SkynetTest implements DomainTest {
	
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
	
	@Test
	public void testCreate() {
		assertNotNull(tweetUrl);
		assertEquals("getTweet: ", tweet, tweetUrl.getTweet());
		assertEquals("getUrl: ", url, tweetUrl.getUrl());
	}

	@Test
	public void testInsert() {
		tweetUrl.save();
		assertEquals(1, TweetUrl.count());
	}
	
	@Test
	public void testSelect() {
		tweetUrl.save();

		TweetUrl postTweetUrl = TweetUrl.select(tweetUrl.getId());

		assertTrue(postTweetUrl.getTweet().getId().equals(tweetUrl.getTweet().getId()));
		assertTrue(postTweetUrl.getUrl().getId().equals(tweetUrl.getUrl().getId()));	
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		Url url = new Url();
		url.setId("asd");
		url.save();
		
		tweet.addUrl(url);
		
		tweet.save();
		
		assertEquals(1, tweet.getUrls().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getUrls().size());
	}
	
	@Test
	public void testSelectFromTweetWithNullUrl() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		Url url = new Url();
		url.setId("asd");
		
		tweet.addUrl(url);
		
		tweet.save();
		
		assertEquals(1, tweet.getUrls().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getUrls().size());
	}	

	@Test
	public void testDelete() {
		tweetUrl.save();
		assertEquals(1, TweetUrl.count());
		tweetUrl.delete();
		assertEquals(0, TweetUrl.count());
	}

	@Test
	public void testExists() {
		tweetUrl.save();
		assertTrue(TweetUrl.exists(tweetUrl));
	}

}
