package toctep.skynet.backend.dal.domain;

public class TweetContributor {

	private Tweet tweet;
	private long userTwitterId;

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public long getUser_twitter_id() {
		return userTwitterId;
	}

	public void setUser_twitter_id(long userTwitterId) {
		this.userTwitterId = userTwitterId;
	}
	
}
