package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.TweetKeyword;

public class TweetKeywordTest extends DomainTest {
	private TweetKeyword tweetKeyword;
	private int tweetId;
	private String keywordValue;
	private int keywordId;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetKeyword = new TweetKeyword();
		
		tweetId = 15;
		keywordValue = "testValue";
		keywordId = 99;
		
		tweetKeyword.setKeywordId(keywordId);
		tweetKeyword.setTweetId(tweetId);
		tweetKeyword.setTweetKeywordValue(keywordValue);
	}

	@Override
	public void testCreate() {
		assertNotNull(tweetKeyword);
		
		assertEquals("getKeywordId: ", keywordId, tweetKeyword.getKeywordId());
		assertEquals("getKeywordValue: ", keywordValue, tweetKeyword.getTweetKeywordValue());
		assertEquals("getTweetId: ", tweetId, tweetKeyword.getTweetId());
	}

	@Override
	public void testInsert() {
		tweetKeywordDao.insert(tweetKeyword);
		
		TweetKeyword postTweetKeyword = (TweetKeyword) tweetKeywordDao.select(tweetKeyword.getId());
		
		assertEquals("getKeywordId: ", tweetKeyword.getKeywordId(), postTweetKeyword.getKeywordId());
		assertEquals("getKeywordValue: ", tweetKeyword.getTweetKeywordValue(), postTweetKeyword.getTweetKeywordValue());
		assertEquals("getTweetId: ", tweetKeyword.getTweetId(), postTweetKeyword.getTweetId());
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
		// TODO Auto-generated method stub

	}

}
