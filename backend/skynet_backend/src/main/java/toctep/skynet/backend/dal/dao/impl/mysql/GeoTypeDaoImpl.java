package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoTypeDaoImpl extends GeoTypeDao {

	@Override
	public void insert(Domain<Integer> domain) {
		GeoType geoType = (GeoType) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(text) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(geoType.getText(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		geoType.setId(id);
	}

	@Override
	public GeoType select(Integer id) {
		GeoType geoType = new GeoType();

		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		geoType.setId(id);
		geoType.setText((String) row.get("text"));
		
		return geoType;
	}

	@Override
	public void delete(Domain<Integer> domain) {
		GeoType geoType = (GeoType) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(geoType.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		GeoType geoType = (GeoType) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "text", new Param(geoType.getText(), Types.VARCHAR));
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
