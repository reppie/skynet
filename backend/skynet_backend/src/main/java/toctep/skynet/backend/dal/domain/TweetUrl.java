package toctep.skynet.backend.dal.domain;

public class TweetUrl extends DomainLongPk {
	
	private Tweet tweet;
	private Url url;

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}
	
}
