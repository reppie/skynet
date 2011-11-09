package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;
import toctep.skynet.backend.test.SkynetTest;

public class TweetKeywordTest extends SkynetTest implements DomainTest {
	
	private TweetKeyword tweetKeyword;
	
	private Tweet tweet;
	private String keywordValue;
	private Keyword keyword;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetKeyword = new TweetKeyword();
		
		tweet = new Tweet();
		tweet.setId(new Long(0));
		
		keywordValue = "testValue";
		
		keyword = new Keyword();
		keyword.setKeyword(keywordValue);
		
		tweetKeyword.setTweet(tweet);
		tweetKeyword.setTweetKeywordValue(keywordValue);
		tweetKeyword.setKeyword(keyword);
	}

	@Test
	public void testCreate() {
		assertNotNull(tweetKeyword);
		
		assertEquals("getKeyword: ", keyword, tweetKeyword.getKeyword());
		assertEquals("getKeywordValue: ", keywordValue, tweetKeyword.getTweetKeywordValue());
		assertEquals("getTweet: ", tweet, tweetKeyword.getTweet());
	}

	@Test
	public void testInsert() {
		tweetKeyword.save();
		assertEquals(1, TweetKeyword.count());
	}

	@Test
	public void testSelect() {}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		String word = "asd";
		
		Keyword keyword = new Keyword();
		keyword.setId(1);
		keyword.setKeyword(word);
		
		tweet.addKeyword(keyword);
		
		tweet.save();
		
		assertEquals(1, tweet.getKeywords().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getKeywords().size());
	}

	@Test
	public void testDelete() {
		tweetKeyword.save();
		assertEquals(1, TweetKeyword.count());
		tweetKeyword.delete();
		assertEquals(0, TweetKeyword.count());
	}

	@Test
	public void testExists() {
		tweetKeyword.save();
		assertTrue(TweetKeyword.exists(tweetKeyword));
	}

}
