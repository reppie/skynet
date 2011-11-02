package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;

public class TweetHashtag extends Domain {
	
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

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getTweetHashtagDao();
	}
	
	public static Object select(Long id) {
		//TODO
		return null;
	}
	
}
