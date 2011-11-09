package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.hashtag.IHashtag;
import toctep.skynet.backend.dal.domain.hashtag.NullHashtag;

public class HashtagDaoImpl extends HashtagDao {

	@Override
	public void insert(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(hashtag.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		hashtag.setId(id);
	}

	@Override
	public Hashtag select(Integer id) {
		Hashtag hashtag = new Hashtag();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);		
		
		hashtag.setId(id);
		hashtag.setText((String) row.get("text"));

		return hashtag;
	}
	
	@Override
	public IHashtag select(String text) {
		String query = "SELECT id FROM " + TABLE_NAME + " WHERE text=?";
		
		Param[] params = new Param[] {
			new Param(text, Types.VARCHAR)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		if (row.size() > 0) {
			return select((Integer) row.get("id"));
		} else {
			return NullHashtag.getInstance();
		}
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(hashtag.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "text", new Param(hashtag.getText(), Types.VARCHAR));
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
