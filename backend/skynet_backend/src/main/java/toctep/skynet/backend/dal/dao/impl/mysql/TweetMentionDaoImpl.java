package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetMentionDaoImpl extends TweetMentionDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetMention tweetMention = (TweetMention) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, user_id) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetMention.getTweet().getId(), Types.BIGINT),
			new Param(tweetMention.getUser().getId(), Types.BIGINT)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetMention.setId(id);
	}

	@Override
	public TweetMention select(Integer id) {
		TweetMention tweetMention = new TweetMention();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweetMention.setId(id);
		tweetMention.setTweet(Tweet.select((Long) row.get("tweet_id")));
		tweetMention.setUser(User.select((Long) row.get("user_id")));
		
		return tweetMention;
	}
	
	@Override
	public List<TweetMention> select(Tweet tweet) {
		List<TweetMention> tweetMentions = new ArrayList<TweetMention>();
		
		String query = "SELECT id, user_id FROM " + tableName + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Map<String, Object>> rows = MySqlUtil.getInstance().select(query, params);
		
		for(Map<String, Object> row : rows) {
			TweetMention tweetMention = new TweetMention();
			tweetMention.setId((Integer) row.get("id"));
			tweetMention.setTweet(tweet);
			tweetMention.setUser(User.select((Long) row.get("user_id")));
			tweetMentions.add(tweetMention);
		}
		return tweetMentions;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetMention tweetMention = (TweetMention) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(tweetMention.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetMention tweetMention = (TweetMention) domain;
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(tweetMention.getId(), Types.INTEGER));
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
