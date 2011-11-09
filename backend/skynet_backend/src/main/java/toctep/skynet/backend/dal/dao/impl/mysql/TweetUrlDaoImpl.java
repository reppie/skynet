package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class TweetUrlDaoImpl extends TweetUrlDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(tweet_id, url_id) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetUrl.getTweet().getId(), Types.BIGINT),
			new Param(tweetUrl.getUrl().getId(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetUrl.setId(id);
	}

	@Override
	public TweetUrl select(Integer id) {
		TweetUrl tweetUrl = new TweetUrl();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweetUrl.setId(id);
		tweetUrl.setTweet(Tweet.select((Long) row.get("tweet_id")));
		tweetUrl.setUrl(Url.select((String) row.get("url_id")));
		
		return tweetUrl;
	}
	
	@Override
	public List<TweetUrl> select(Tweet tweet) {
		List<TweetUrl> tweetUrls = new ArrayList<TweetUrl>();
		
		String query = "SELECT id, url_id FROM " + TABLE_NAME + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Map<String, Object>> rows = MySqlUtil.getInstance().select(query, params);
		
		for(Map<String, Object> row : rows) {
			TweetUrl tweetUrl = new TweetUrl();
			tweetUrl.setId((Integer) row.get("id"));
			tweetUrl.setTweet(tweet);
			tweetUrl.setUrl(Url.select((String) row.get("url_id")));
			tweetUrls.add(tweetUrl);
		}
		
		return tweetUrls;
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;	
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(tweetUrl.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(tweetUrl.getId(), Types.INTEGER));
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
