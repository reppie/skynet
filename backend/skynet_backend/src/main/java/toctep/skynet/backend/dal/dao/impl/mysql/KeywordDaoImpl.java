package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.DomainLongPk;
import toctep.skynet.backend.dal.domain.Keyword;

public class KeywordDaoImpl extends KeywordDao {

	@Override
	public void insert(Domain domain) {
		Keyword keyword = (Keyword) domain;
		
		int id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (keyword) " +
				"VALUES (" + keyword.getKeyword() + ")" 
				);
		
		keyword.setId(id);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
