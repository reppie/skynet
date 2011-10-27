package toctep.skynet.backend.dal.domain;

public class TweetHashtag {
	
	private Tweet tweet;
	private Hashtag hashtag;
	
	public TweetHashtag() {		
	}
	
	public TweetHashtag(Tweet tweet, Hashtag hashtag) {
		super();
		this.tweet = tweet;
		this.hashtag = hashtag;
	}

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
