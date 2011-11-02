package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;

import toctep.skynet.backend.dal.dao.UrlDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.Url;

public class UrlDaoImpl extends UrlDao {

	@Override
	public void insert(Domain<String> domain) {
		Url url = (Url) domain;

		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(url.getId(), Types.VARCHAR)
		};
			
		MySqlUtil.getInstance().insert(query, params);
	}

	@Override
	public Url select(String id) {
		Url url = new Url();
		
		String query = "SELECT * FROM " + tableName + " WHERE text=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.VARCHAR)
		};
		
		MySqlUtil.getInstance().select(query, params);
		
		url.setId(id);
		
		return url;
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
		return this.exists(url.getId());
	}
	
	@Override
	public boolean exists(String id) {
		return MySqlUtil.getInstance().exists(tableName, "text=" + MySqlUtil.escape(id));
	}	

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
