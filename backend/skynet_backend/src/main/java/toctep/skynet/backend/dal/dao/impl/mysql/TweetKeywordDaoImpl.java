package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.NullKeyword;
import toctep.skynet.backend.dal.domain.tweet.NullTweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetKeywordDaoImpl extends TweetKeywordDao {

	@Override
	public void insert(Domain<Long> domain) {
		TweetKeyword tweetKeyword = (TweetKeyword) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, value, keyword_id) VALUES(?, ?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetKeyword.getTweet().getId(), Types.BIGINT),
			new Param(tweetKeyword.getTweetKeywordValue(), Types.VARCHAR),
			new Param(tweetKeyword.getKeyword().getId(), Types.BIGINT)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		tweetKeyword.setId(id);
	}

	@Override
	public TweetKeyword select(Long id) {
		TweetKeyword tweetKeyword = new TweetKeyword();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(tweetKeyword.getId(), Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		tweetKeyword.setId(id);
		tweetKeyword.setTweet(new NullTweet()); //TODO
		tweetKeyword.setTweetKeywordValue((String) record.get(2));
		tweetKeyword.setKeyword(new NullKeyword()); //TODO
		
		return tweetKeyword;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
