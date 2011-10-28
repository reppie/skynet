package toctep.skynet.backend.dal.domain;

public class TweetMention extends Domain {
	
	private Tweet tweet;
	private long user;

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

	@Override
	public void setDao() {
		dao = daoFacade.getTweetMentionDao();
	}
}
