package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;

public class TweetContributorDaoImpl extends TweetContributorDao {

	@Override
	public void insert(Domain<Long> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public TweetContributor select(Long id) {
		// TODO Auto-generated method stub
		return null;
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
