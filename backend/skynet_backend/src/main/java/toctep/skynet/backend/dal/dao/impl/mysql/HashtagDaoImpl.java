package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;

public class HashtagDaoImpl extends HashtagDao{

	@Override
	public void insert(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(hashtag.getText(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		hashtag.setId(id);
	}

	@Override
	public Hashtag select(Long id) {
		Hashtag hashtag = new Hashtag();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(hashtag.getId(), Types.BIGINT)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);		
		
		hashtag.setId(id);
		try {
			hashtag.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hashtag;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + hashtag.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + hashtag.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
