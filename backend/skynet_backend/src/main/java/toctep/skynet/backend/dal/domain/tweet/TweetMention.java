package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;

public class TweetMention extends TweetUser {
	
	public TweetMention() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetMentionDao());
	}
	
	public static TweetMention select(Integer id) {
		TweetMentionDao dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
		return (TweetMention) dao.select(id);
	}
	
	public static List<TweetMention> select(Tweet tweet) {
		TweetMentionDao dao = DaoFacadeImpl.getInstance().getTweetMentionDao();
		return dao.select(tweet);
	}
	
}
