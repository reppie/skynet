package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.SourceType;

public class SourceTypeDaoImpl extends SourceTypeDao {

	@Override
	public void insert(Domain domain) {
		SourceType sourceType = (SourceType) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (text) VALUES ('" + sourceType.getText() + "')"
		);
		
		sourceType.setId(id);
	}

	@Override
	public SourceType select(long id) {
		SourceType sourceType = new SourceType();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);			
		
		sourceType.setId(id);
		
		try {
			sourceType.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sourceType;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void delete(Domain domain) {
		SourceType sourceType = (SourceType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + sourceType.getId());		
	}

	@Override
	public boolean exists(Domain domain) {
		SourceType sourceType = (SourceType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + sourceType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
}
