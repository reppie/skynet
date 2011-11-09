package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;

public class TweetContributor extends TweetUser {

	public TweetContributor() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetContributorDao());
	}
	
	public static TweetContributor select(Integer id) {
		TweetContributorDao dao = DaoFacadeImpl.getInstance().getTweetContributorDao();
		return (TweetContributor) dao.select(id);
	}

	public static List<TweetContributor> select(Tweet tweet) {
		TweetContributorDao dao = DaoFacadeImpl.getInstance().getTweetContributorDao();
		return dao.select(tweet);
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getTweetContributorDao().count();
	}
	
	public static boolean exists(TweetContributor tweetContributor) {
		return DaoFacadeImpl.getInstance().getTweetContributorDao().exists(tweetContributor);
	}
	
}
