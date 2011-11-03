package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetKeywordDaoImpl extends TweetKeywordDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetKeyword tweetKeyword = (TweetKeyword) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, value, keyword_id) VALUES(?, ?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetKeyword.getTweet().getId(), Types.BIGINT),
			new Param(tweetKeyword.getTweetKeywordValue(), Types.VARCHAR),
			new Param(tweetKeyword.getKeyword().getId(), Types.BIGINT)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetKeyword.setId(id);
	}

	@Override
	public TweetKeyword select(Integer id) {
		TweetKeyword tweetKeyword = new TweetKeyword();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().selectRecord(query, params);
		
		tweetKeyword.setId(id);
		tweetKeyword.setTweet(Tweet.select((Long) record.get(1)));
		tweetKeyword.setTweetKeywordValue((String) record.get(2));
		tweetKeyword.setKeyword(Keyword.select((Integer) record.get(3)));
		
		return tweetKeyword;
	}
	
	public List<TweetKeyword> select(Tweet tweet) {
		List<TweetKeyword> tweetKeywords = new ArrayList<TweetKeyword>();
		
		String query = "SELECT id, value, keyword_id FROM " + tableName + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<List<Object>> records = MySqlUtil.getInstance().select(query, params);
		
		for(List<Object> record : records) {
			TweetKeyword tweetKeyword = new TweetKeyword();
			tweetKeyword.setId((Integer) record.get(0));
			tweetKeyword.setTweet(tweet);
			tweetKeyword.setTweetKeywordValue((String) record.get(1));
			tweetKeyword.setKeyword(Keyword.select((Integer) record.get(2)));
			tweetKeywords.add(tweetKeyword);
		}
		return tweetKeywords;
	}	

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetKeyword tweetkeyword = (TweetKeyword) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(tweetkeyword.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetKeyword tweetkeyword = (TweetKeyword) domain;
		return this.exists(tweetkeyword.getId());
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
