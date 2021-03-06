package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.keyword.IKeyword;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.keyword.NullKeyword;

public class KeywordDaoImpl extends KeywordDao {

	@Override
	public void insert(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + " (keyword) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(keyword.getKeyword(), Types.VARCHAR)
		};
		
		int id = MySqlUtil.getInstance().insert(query, params);
		
		keyword.setId(id);
	}

	@Override
	public Keyword select(Integer id) {
		Keyword keyword = new Keyword();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.INTEGER)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		keyword.setId(id);
		keyword.setKeyword((String) row.get("keyword"));
		
		return keyword;
	}

	@Override
	public IKeyword select(String keyword) {
		String query = "SELECT id FROM " + TABLE_NAME + " WHERE keyword=?";
		
		Param[] params = new Param[] {
			new Param(keyword, Types.VARCHAR)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		if (row.size() > 0) {
			return select((Integer) row.get("id"));
		} else {
			return NullKeyword.getInstance();
		}
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;	
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(keyword.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "keyword", new Param(keyword.getKeyword(), Types.VARCHAR));
	}
	
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
