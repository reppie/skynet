package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Language;

public class LanguageDaoImpl extends LanguageDao{

	@Override
	public void insert(Domain domain) {
		Language language = (Language) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (text) " +
			"VALUES ('" + language.getText() + "')"
		);
		
		language.setId(id);
	}

	@Override
	public Language select(long id) {
		Language language = new Language();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);			
		
		language.setId(id);
		
		try {
			language.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return language;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain domain) {
		Language language = (Language) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + language.getId());
	}

	@Override
	public boolean exists(Domain domain) {
		Language language = (Language) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + language.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
