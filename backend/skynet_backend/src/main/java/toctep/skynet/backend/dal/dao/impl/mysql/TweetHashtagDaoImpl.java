package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;

public class TweetHashtagDaoImpl extends TweetHashtagDao {

	@Override
	public void insert(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public TweetHashtag select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweetHashtag.getId());
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;
		return this.exists(tweetHashtag.getId());
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
