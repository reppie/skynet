package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.Url;

public class TweetUrl extends Domain {
	
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

	@Override
	public void setDao() {
		dao = daoFacade.getTweetUrlDao();
	}
}
