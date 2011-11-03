package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;

public class HashtagDaoImpl extends HashtagDao{

	@Override
	public void insert(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(hashtag.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		hashtag.setId(id);
	}

	@Override
	public Hashtag select(Integer id) {
		Hashtag hashtag = new Hashtag();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);		
		
		hashtag.setId(id);
		hashtag.setText((String) row.get("text"));

		return hashtag;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(hashtag.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		Hashtag hashtag = (Hashtag) domain;
		return MySqlUtil.getInstance().exists(tableName, "text", new Param(hashtag.getText(), Types.VARCHAR));
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
