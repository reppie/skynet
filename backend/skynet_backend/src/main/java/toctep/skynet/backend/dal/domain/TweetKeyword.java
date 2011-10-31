package toctep.skynet.backend.dal.domain;

public class TweetKeyword extends DomainLongPk {
	
	private long tweetId;
	private String tweetKeywordValue;
	private long keywordId;
	
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	
	public String getTweetKeywordValue() {
		return tweetKeywordValue;
	}
	public void setTweetKeywordValue(String tweetKeywordValue) {
		this.tweetKeywordValue = tweetKeywordValue;
	}
	
	public long getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(long keywordId) {
		this.keywordId = keywordId;
	}
	@Override
	public void setDao() {
		dao = daoFacade.getTweetKeywordDao();
	}
}
