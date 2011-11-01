package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;

public class TweetContributor extends Domain {

	private Tweet tweet;
	private long userTwitterId;

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public long getUserTwitterId() {
		return userTwitterId;
	}

	public void setUserTwitterId(long userTwitterId) {
		this.userTwitterId = userTwitterId;
	}

	@Override
	public void setDao() {
		dao = getDaoFacade().getTweetContributorDao();
	}
}
