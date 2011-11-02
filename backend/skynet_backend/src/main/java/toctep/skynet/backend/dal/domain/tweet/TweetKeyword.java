package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;

public class TweetKeyword extends Domain<Long> {
	
	private ITweet tweet;
	private String tweetKeywordValue;
	private IKeyword keyword;
	
	public ITweet getTweet() {
		return tweet;
	}
	
	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}
	
	public String getTweetKeywordValue() {
		return tweetKeywordValue;
	}
	
	public void setTweetKeywordValue(String tweetKeywordValue) {
		this.tweetKeywordValue = tweetKeywordValue;
	}
	
	public IKeyword getKeyword() {
		return keyword;
	}
	
	public void setKeyword(IKeyword keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public void setDao() {
		dao = getDaoFacade().getTweetKeywordDao();
	}
	
	@Override
	public void save() {
		if (tweet instanceof Tweet) {
			((Tweet) tweet).save();
			((Tweet) this.tweet).setId(((Tweet) tweet).getId());
		}
		
		if (keyword instanceof Keyword) {
			((Keyword) keyword).save();
			((Keyword) this.keyword).setId(((Keyword) keyword).getId());
		}
		
		super.save();
	}	
}
