package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetContributor extends Domain<Integer> {

	private ITweet tweet;
	private IUser user;

	public TweetContributor() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetContributorDao());
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
		
		if (tweet instanceof Tweet && ((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
			((Tweet) this.tweet).setId(((Tweet) tweet).getId());
		}
		
		if (user instanceof User) {
			((User) user).save();
			((User) this.user).setId(((User) user).getId());
		}
		
		super.save();
	}	
	
	public static TweetContributor select(Integer id) {
		TweetContributorDao dao = DaoFacadeImpl.getInstance().getTweetContributorDao();
		
		if (dao.exists(id)) {
			return (TweetContributor) dao.select(id);
		}
		
		return null;
	}

	public static List<TweetContributor> select(Tweet tweet) {
		TweetContributorDao dao = DaoFacadeImpl.getInstance().getTweetContributorDao();
		return dao.select(tweet);
	}	
}
