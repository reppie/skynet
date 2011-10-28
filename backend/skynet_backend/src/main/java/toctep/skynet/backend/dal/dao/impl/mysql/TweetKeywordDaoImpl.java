package toctep.skynet.backend.dal.dao.impl.mysql;

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
                         tweetKeyword.getTweetKeywordValue()+ ", "+
						 tweetKeyword.getKeywordId()+")"
		);
		
		tweetKeyword.setId(id);
	}

	@Override
	public DomainLongPk select(long id) {
		// TODO Auto-generated method stub
		return null;
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
