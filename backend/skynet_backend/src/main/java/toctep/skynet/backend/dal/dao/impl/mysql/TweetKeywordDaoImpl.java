package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
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
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		tweetKeyword.setId(id);
		try {
			tweetKeyword.setTweetKeywordValue(rs.getString("value"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
