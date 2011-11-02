package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.IUser;

public class TweetMention extends Domain<Integer> {
	
	private ITweet tweet;
	private IUser user;

	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
	}
	
	public static TweetMention select(Integer id) {
		TweetMentionDao dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
		
		if (dao.exists(id)) {
			return (TweetMention) dao.select(id);
		}
		
		return null;
	}
	
}
