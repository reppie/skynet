package toctep.skynet.backend.dal.domain;

public class TweetMention {
	
	private Tweet tweet;
	private User user;
	
	public TweetMention() {
		super();
	}

	public TweetMention(Tweet tweet, User user) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}		
}
