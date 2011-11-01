package toctep.skynet.backend.dal.domain;

public class TweetKeyword extends DomainLongPk {
	
	private Tweet tweet;
	private String tweetKeywordValue;
	private Keyword keyword;
	
	public Tweet getTweet() {
		return tweet;
	}
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public String getTweetKeywordValue() {
		return tweetKeywordValue;
	}
	public void setTweetKeywordValue(String tweetKeywordValue) {
		this.tweetKeywordValue = tweetKeywordValue;
	}
	
	public Keyword getKeyword() {
		return keyword;
	}
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}
	@Override
	public void setDao() {
		dao = daoFacade.getTweetKeywordDao();
	}
	
	@Override
	public void save() {
		tweet.save();
		keyword.save();
		this.tweet.setId(tweet.getId());
		this.keyword.setId(keyword.getId());
		super.save();
	}	
}
