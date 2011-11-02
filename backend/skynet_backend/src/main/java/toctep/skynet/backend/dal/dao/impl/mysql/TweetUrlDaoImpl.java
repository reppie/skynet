package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class TweetUrlDaoImpl extends TweetUrlDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, url_id) VALUES(?, ?)";
		
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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		tweetUrl.setId(id);
		tweetUrl.setTweet(Tweet.select((Long) record.get(1)));
		tweetUrl.setUrl(Url.select((String) record.get(2)));
		
		return tweetUrl;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;	
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(tweetUrl.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;
		return this.exists(tweetUrl.getId());
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
