package toctep.skynet.backend.dal.domain;

public class TweetHashtag extends DomainLongPk {
	
	private Tweet tweet;
	private Hashtag hashtag;
	
	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public Hashtag getHashtag() {
		return hashtag;
	}

	public void setHashtag(Hashtag hashtag) {
		this.hashtag = hashtag;
	}
	
}
