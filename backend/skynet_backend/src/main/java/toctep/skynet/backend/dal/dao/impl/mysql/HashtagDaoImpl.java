package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Hashtag;

public class HashtagDaoImpl extends HashtagDao{

	@Override
	public void delete(Domain domain) {
		Hashtag hashtag = (Hashtag) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + hashtag.getId());
	}

	@Override
	public void insert(Domain domain) {
		Hashtag hashtag = (Hashtag) domain;
		int id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (text) VALUES ('" + hashtag.getText() + "')"
				);
		
		hashtag.setId(id);
	}

	@Override
	public Hashtag select(long id) {
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
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
