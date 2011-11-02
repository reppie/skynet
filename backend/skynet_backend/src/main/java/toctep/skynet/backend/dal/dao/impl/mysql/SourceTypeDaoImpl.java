package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.SourceType;

public class SourceTypeDaoImpl extends SourceTypeDao {

	@Override
	public void insert(Domain<Long> domain) {
		SourceType sourceType = (SourceType) domain;
		
		String query = "INSERT INTO " + tableName + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(sourceType.getText(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		sourceType.setId(id);
	}

	@Override
	public SourceType select(Long id) {
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
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void delete(Domain<Long> domain) {
		SourceType sourceType = (SourceType) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + sourceType.getId());		
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		SourceType sourceType = (SourceType) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + sourceType.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
}
