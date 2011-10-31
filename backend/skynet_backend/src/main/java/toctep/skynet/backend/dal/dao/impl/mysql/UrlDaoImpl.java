package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.UrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.DomainStringPk;
import toctep.skynet.backend.dal.domain.Url;

public class UrlDaoImpl extends UrlDao {

	@Override
	public void insert(Domain domain) {
		Url url = (Url) domain;

		MySqlUtil.getInstance().insert("INSERT INTO " 
					+ tableName 
					+ " (text) VALUES (" 
					+ MySqlUtil.escape(url.getId()) + ")"
					);
	}

	@Override
	public DomainStringPk select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain domain) {
		Url url = (Url) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE text = " + MySqlUtil.escape(url.getId()));
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
