package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(sourceType.getId(), Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		sourceType.setId(id);	
		sourceType.setText((String) record.get(1));
		
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
		return this.exists(sourceType.getId());
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
