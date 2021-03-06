package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoDaoImpl extends GeoDao {
	
	@Override
	public void insert(Domain<Integer> domain) {
		Geo geo = (Geo) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(geo_type_id, coordinates) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(geo.getType().getId(), Types.BIGINT),
			new Param(geo.getCoordinates(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		geo.setId(id);
	}

	@Override
	public Geo select(Integer id) {
		Geo geo = new Geo();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		geo.setId(id);
		geo.setType(GeoType.select((Integer) row.get("geo_type_id")));
		geo.setCoordinates((String) row.get("coordinates"));
		
		return geo;
	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		Geo geo = (Geo) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(geo.getId(), Types.INTEGER) }
		);
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		Geo geo = (Geo) domain;
		Map<String, Param> params = new HashMap<String, Param>();
		params.put("coordinates", new Param(geo.getCoordinates(), Types.VARCHAR));
		return MySqlUtil.getInstance().exists(TABLE_NAME, params);
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
