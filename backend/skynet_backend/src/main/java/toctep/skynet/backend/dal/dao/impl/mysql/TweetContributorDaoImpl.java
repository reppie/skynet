package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;

public class TweetContributorDaoImpl extends TweetContributorDao {

	@Override
	public void insert(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public TweetContributor select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;	
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweetContributor.getId());
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetContributor tweetContributor = (TweetContributor) domain;
		return this.exists(tweetContributor.getId());
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
