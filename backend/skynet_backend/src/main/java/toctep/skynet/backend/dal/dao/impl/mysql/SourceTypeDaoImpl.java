package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.sourcetype.SourceType;

public class SourceTypeDaoImpl extends SourceTypeDao {

	@Override
	public void insert(Domain<Integer> domain) {
		SourceType sourceType = (SourceType) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(sourceType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		sourceType.setId(id);
	}

	@Override
	public SourceType select(Integer id) {
		SourceType sourceType = new SourceType();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		sourceType.setId(id);	
		sourceType.setText((String) row.get("text"));
		
		return sourceType;
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		SourceType sourceType = (SourceType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(sourceType.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		SourceType sourceType = (SourceType) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "text", new Param(sourceType.getText(), Types.VARCHAR));
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
