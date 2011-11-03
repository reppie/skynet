package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.language.Language;

public class LanguageDaoImpl extends LanguageDao{

	@Override
	public void insert(Domain<Integer> domain) {
		Language language = (Language) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(language.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		language.setId(id);
	}

	@Override
	public Language select(Integer id) {
		Language language = new Language();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		language.setId(id);
		language.setText((String) row.get("text"));
		
		return language;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		Language language = (Language) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(language.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		Language language = (Language) domain;
		return MySqlUtil.getInstance().exists(tableName, "text", new Param(language.getText(), Types.VARCHAR));
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
