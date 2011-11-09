package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetKeywordDaoImpl extends TweetKeywordDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetKeyword tweetKeyword = (TweetKeyword) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(tweet_id, value, keyword_id) VALUES(?, ?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetKeyword.getTweet().getId(), Types.BIGINT),
			new Param(tweetKeyword.getTweetKeywordValue(), Types.VARCHAR),
			new Param(tweetKeyword.getKeyword().getId(), Types.INTEGER)
		};
		
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetKeyword.setId(id);
	}

	@Override
	public TweetKeyword select(Integer id) {
		TweetKeyword tweetKeyword = new TweetKeyword();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweetKeyword.setId(id);
		tweetKeyword.setTweet(Tweet.select((Long) row.get("tweet_id")));
		tweetKeyword.setTweetKeywordValue((String) row.get("value"));
		tweetKeyword.setKeyword(Keyword.select((Integer) row.get("keyword_id")));
		
		return tweetKeyword;
	}
	
	public List<TweetKeyword> select(Tweet tweet) {
		List<TweetKeyword> tweetKeywords = new ArrayList<TweetKeyword>();
		
		String query = "SELECT id, value, keyword_id FROM " + TABLE_NAME + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Map<String, Object>> rows = MySqlUtil.getInstance().select(query, params);
		
		for(Map<String, Object> row : rows) {
			TweetKeyword tweetKeyword = new TweetKeyword();
			tweetKeyword.setId((Integer) row.get("id"));
			tweetKeyword.setTweet(tweet);
			tweetKeyword.setTweetKeywordValue((String) row.get("value"));
			tweetKeyword.setKeyword(Keyword.select((Integer) row.get("keyword_id")));
			tweetKeywords.add(tweetKeyword);
		}
		
		return tweetKeywords;
	}	

	@Override
	public void delete(Domain<Integer> domain) {
		TweetKeyword tweetkeyword = (TweetKeyword) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(tweetkeyword.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetKeyword tweetKeyword = (TweetKeyword) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(tweetKeyword.getId(), Types.INTEGER));
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
