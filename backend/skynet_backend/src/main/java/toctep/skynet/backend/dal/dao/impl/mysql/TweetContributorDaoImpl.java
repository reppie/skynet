package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetContributorDaoImpl extends TweetContributorDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, user_id) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetContributor.getTweet().getId(), Types.BIGINT),
			new Param(tweetContributor.getUser().getId(), Types.BIGINT)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetContributor.setId(id);
	}

	@Override
	public TweetContributor select(Integer id) {
		TweetContributor tweetContributor = new TweetContributor();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		tweetContributor.setId(id);
		tweetContributor.setTweet(Tweet.select((Long) record.get(1)));
		tweetContributor.setUser(User.select((Long) record.get(2)));
		
		return tweetContributor;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(tweetContributor.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		return this.exists(tweetContributor.getId());
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id=" + id);
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
