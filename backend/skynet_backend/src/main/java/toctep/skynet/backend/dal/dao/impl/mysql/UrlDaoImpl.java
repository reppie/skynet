package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.UrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.Url;

public class UrlDaoImpl extends UrlDao {

	@Override
	public void insert(Domain<String> domain) {
		Url url = (Url) domain;

		MySqlUtil.getInstance().insert("INSERT INTO " 
					+ tableName 
					+ " (text) VALUES (" 
					+ MySqlUtil.escape(url.getId()) + ")"
					);
	}

	@Override
	public Url select(String id) {
		return null;
	}

	@Override
	public void update(Domain<String> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<String> domain) {
		Url url = (Url) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE text = " + MySqlUtil.escape(url.getId()));
	}

	@Override
	public boolean exists(Domain<String> domain) {
		Url url = (Url) domain;
		return MySqlUtil.getInstance().exists(tableName, "text = " + MySqlUtil.escape(url.getId()));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
