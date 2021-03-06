package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetContributorDaoImpl extends TweetContributorDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(tweet_id, user_id) VALUES(?, ?)";
		
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
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweetContributor.setId(id);
		tweetContributor.setTweet(Tweet.select((Long) row.get("tweet_id")));
		tweetContributor.setUser(User.select((Long) row.get("user_id")));
		
		return tweetContributor;
	}
	
	@Override
	public List<TweetContributor> select(Tweet tweet) {
		List<TweetContributor> tweetContributors = new ArrayList<TweetContributor>();
		
		String query = "SELECT id, user_id FROM " + TABLE_NAME + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Map<String, Object>> rows = MySqlUtil.getInstance().select(query, params);
		
		for(Map<String, Object> row : rows) {
			TweetContributor tweetContributor = new TweetContributor();
			tweetContributor.setId((Integer) row.get("id"));
			tweetContributor.setTweet(tweet);
			tweetContributor.setUser(User.select((Long) row.get("user_id")));
			tweetContributors.add(tweetContributor);
		}
		
		return tweetContributors;
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(tweetContributor.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		Map<String, Param> params = new HashMap<String, Param>();
		params.put("tweet_id", new Param(tweetContributor.getTweet().getId(), Types.BIGINT));
		params.put("user_id", new Param(tweetContributor.getUser().getId(), Types.BIGINT));
		return MySqlUtil.getInstance().exists(TABLE_NAME, params);
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
