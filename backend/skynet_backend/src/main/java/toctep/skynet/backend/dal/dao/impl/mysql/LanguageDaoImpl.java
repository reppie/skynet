package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.language.Language;

public class LanguageDaoImpl extends LanguageDao{

	@Override
	public void insert(Domain<Long> domain) {
		Language language = (Language) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(language.getText(), Types.VARCHAR)
		};
			
		long id = MySqlUtil.getInstance().insert(query, params);
		
		language.setId(id);
	}

	@Override
	public Language select(Long id) {
		Language language = new Language();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		language.setId(id);
		language.setText((String) record.get(1));
		
		return language;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Long> domain) {
		Language language = (Language) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + language.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		Language language = (Language) domain;
		return this.exists(language.getId());
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
