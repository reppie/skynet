package toctep.skynet.backend.dal.domain;

public class TweetMention {
	
	private Tweet tweet;
	private long user;
	
	public TweetMention() {
		super();
	}

	public TweetMention(Tweet tweet, long user) {
		super();
		this.tweet = tweet;
		this.user = user;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}		
}
