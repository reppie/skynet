package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoDaoImpl extends GeoDao {
	
	@Override
	public void insert(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		
		String query = "INSERT INTO " + tableName + "(geo_type_id, coordinates) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(geo.getType().getId(), Types.BIGINT),
			new Param(geo.getCoordinates(), Types.VARCHAR)
		};
			
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		geo.setId(id);
	}

	@Override
	public Geo select(Long id) {
		Geo geo = new Geo();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		System.out.println("test: " + (Long) record.get(1));
		geo.setId(id);
		geo.setType(GeoType.select((Long) record.get(1)));
		geo.setCoordinates((String) record.get(2));
		
		return geo;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + geo.getId());
	}
	
	@Override
	public boolean exists(Domain<Long> domain) {
		Geo geo = (Geo) domain;
		return this.exists(geo.getId());
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
