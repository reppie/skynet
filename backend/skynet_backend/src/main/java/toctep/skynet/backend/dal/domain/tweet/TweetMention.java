package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetMention extends Domain<Long> {
	
	private ITweet tweet;
	private IUser user;

	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
	}
	
	public static Object select(Long id) {
		//TODO
		return null;
	}
	
}
