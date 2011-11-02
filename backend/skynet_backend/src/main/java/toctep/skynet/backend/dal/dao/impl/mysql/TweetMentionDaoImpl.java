package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;

public class TweetMentionDaoImpl extends TweetMentionDao {

	@Override
	public void insert(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TweetMention select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetMention tweetMention = (TweetMention) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweetMention.getId());
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetMention tweetMention = (TweetMention) domain;
		return this.exists(tweetMention.getId());
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
