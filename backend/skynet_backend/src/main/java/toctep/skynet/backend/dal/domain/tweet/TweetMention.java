package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.IUser;

public class TweetMention extends Domain<Integer> {
	
	private ITweet tweet;
	private IUser user;

	public TweetMention() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetMentionDao());
	}
	
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
	public void save() {
		
		if (((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
		}
		
		user.save();
		
		super.save();
	}	
	
	public static TweetMention select(Integer id) {
		TweetMentionDao dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
		
		if (dao.exists(id)) {
			return (TweetMention) dao.select(id);
		}
		
		return null;
	}
	
	public static List<TweetMention> select(Tweet tweet) {
		TweetMentionDao dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
		return dao.select(tweet);
	}
	
}
