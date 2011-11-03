package toctep.skynet.backend.test.dal;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.tweet.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetKeywordTest extends DomainTest {
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

	@Override
	public void testCreate() {
		assertNotNull(tweetKeyword);
		
		assertEquals("getKeyword: ", keyword, tweetKeyword.getKeyword());
		assertEquals("getKeywordValue: ", keywordValue, tweetKeyword.getTweetKeywordValue());
		assertEquals("getTweet: ", tweet, tweetKeyword.getTweet());
	}

	@Override
	public void testInsert() {
		tweetKeyword.save();
		assertEquals(1, tweetKeywordDao.count());
	}

	@Override
	public void testSelect() {
		tweetKeyword.save();
		
		TweetKeyword postTweetKeyword = (TweetKeyword) tweetKeywordDao.select(tweetKeyword.getId());
		
		assertTrue(postTweetKeyword.getTweet().getId().equals(tweetKeyword.getTweet().getId()));
		assertTrue(postTweetKeyword.getTweetKeywordValue().equals(tweetKeyword.getTweetKeywordValue()));
		assertTrue(postTweetKeyword.getKeyword().getId().equals(tweetKeyword.getKeyword().getId()));
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		String word = "asd";
		
		Keyword keyword = new Keyword();
		keyword.setId(1);
		keyword.setKeyword(word);
		
		TweetKeyword tweetKeyword = new TweetKeyword();
		tweetKeyword.setTweet(tweet);
		tweetKeyword.setTweetKeywordValue(word);
		tweetKeyword.setKeyword(keyword);
		
		tweet.addKeyword(tweetKeyword);
		
		tweet.save();
		
		assertEquals(1, tweet.getKeywords().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getKeywords().size());
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
