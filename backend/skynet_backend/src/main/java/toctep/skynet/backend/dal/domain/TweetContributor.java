package toctep.skynet.backend.dal.domain;

public class TweetContributor {

	private Tweet tweet;
	private long user_twitter_id;
	
	public TweetContributor() {
		super();
	}
	
	public TweetContributor(Tweet tweet, long userTwitterId) {
		super();
		this.tweet = tweet;
		user_twitter_id = userTwitterId;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public long getUser_twitter_id() {
		return user_twitter_id;
	}

	public void setUser_twitter_id(long userTwitterId) {
		user_twitter_id = userTwitterId;
	}
	
	
}
