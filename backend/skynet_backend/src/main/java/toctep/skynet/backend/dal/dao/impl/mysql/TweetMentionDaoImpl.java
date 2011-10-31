package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.DomainLongPk;

public class TweetMentionDaoImpl extends TweetMentionDao {

	@Override
	public void insert(Domain domain) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
