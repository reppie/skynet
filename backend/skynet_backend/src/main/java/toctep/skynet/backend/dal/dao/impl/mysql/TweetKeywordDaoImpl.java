package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.DomainLongPk;
import toctep.skynet.backend.dal.domain.TweetKeyword;

public class TweetKeywordDaoImpl extends TweetKeywordDao {

	@Override
	public void insert(Domain domain) {
		TweetKeyword tweetKeyword = (TweetKeyword) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (tweet_id, value, keyword_id) " +
			"VALUES (" + tweetKeyword.getTweetId() + ", " + 
                         MySqlUtil.escape(tweetKeyword.getTweetKeywordValue()) + ", "+
						 tweetKeyword.getKeywordId()+")"
		);
		
		tweetKeyword.setId(id);
	}

	@Override
	public DomainLongPk select(long id) {
		TweetKeyword tweetKeyword = new TweetKeyword();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		tweetKeyword.setId(id);
		try {
			tweetKeyword.setKeywordId(rs.getInt("keyword_id"));
			tweetKeyword.setTweetId(rs.getLong("tweet_id"));
			tweetKeyword.setTweetKeywordValue(rs.getString("value"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tweetKeyword;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain domain) {
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
