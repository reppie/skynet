package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.TweetKeyword;

public class TweetKeywordTest extends DomainTest {

	@Override
	public void testCreate() {
		TweetKeyword tweetKeyword = new TweetKeyword();
		assertNotNull(tweetKeyword);
		
		int tweetId = 15;
		String keywordValue = "testValue";
		int keywordId = 99;
		
		tweetKeyword.setKeywordId(keywordId);
		tweetKeyword.setTweetId(tweetId);
		tweetKeyword.setTweetKeywordValue(keywordValue);
		assertEquals("getKeywordId: ", keywordId, tweetKeyword.getKeywordId());
		assertEquals("getKeywordValue: ", keywordValue, tweetKeyword.getTweetKeywordValue());
		assertEquals("getTweetId: ", tweetId, tweetKeyword.getTweetId());
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub

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
