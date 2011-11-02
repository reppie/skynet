package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;

public class TweetMentionDaoImpl extends TweetMentionDao {

	@Override
	public void insert(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TweetMention select(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		TweetMention tweetMention = (TweetMention) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweetMention.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		TweetMention tweetMention = (TweetMention) domain;
		return this.exists(tweetMention.getId());
	}
	
	@Override
	public boolean exists(Long id) {
		return MySqlUtil.getInstance().exists(tableName, "id=" + id);
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
