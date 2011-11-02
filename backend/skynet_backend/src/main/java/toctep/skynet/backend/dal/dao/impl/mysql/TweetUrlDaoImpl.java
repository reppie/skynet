package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;

public class TweetUrlDaoImpl extends TweetUrlDao {

	@Override
	public void insert(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TweetUrl select(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweetUrl.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		TweetUrl tweetUrl = (TweetUrl) domain;
		return this.exists(tweetUrl.getId());
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
