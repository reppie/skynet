package toctep.skynet.backend.test.dal;

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
		keyword.setId(0);
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

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub

	}

}
