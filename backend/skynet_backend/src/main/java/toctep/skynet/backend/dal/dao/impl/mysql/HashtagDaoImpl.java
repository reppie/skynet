package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;

public class HashtagDaoImpl extends HashtagDao{

	@Override
	public void delete(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + hashtag.getId());
	}

	@Override
	public void insert(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		
		long id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (text) VALUES ('" + hashtag.getText() + "')"
				);
		
		hashtag.setId(id);
	}

	@Override
	public Hashtag select(Long id) {
		Hashtag hashtag = new Hashtag();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
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
	public boolean exists(Domain<Long> domain) {
		Hashtag hashtag = (Hashtag) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + hashtag.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
