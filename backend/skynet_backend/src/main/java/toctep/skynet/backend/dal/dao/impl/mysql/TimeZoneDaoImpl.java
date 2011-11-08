package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;

public class TimeZoneDaoImpl extends TimeZoneDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TimeZone timeZone = (TimeZone) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(utc_offset, time_zone) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(timeZone.getUtcOffset(), Types.INTEGER),
			new Param(timeZone.getTimeZone(), Types.VARCHAR)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		timeZone.setId(id);
	}

	@Override
	public TimeZone select(Integer id) {
		TimeZone timeZone = new TimeZone();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		timeZone.setId(id);
		timeZone.setUtcOffset((Integer) row.get("utc_offset"));
		timeZone.setTimeZone((String) row.get("time_zone"));
		
		return timeZone;
	}

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void delete(Domain<Integer> domain) {
		TimeZone timeZone = (TimeZone) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(timeZone.getId(), Types.INTEGER) }
		);
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		TimeZone timeZone = (TimeZone) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "time_zone", new Param(timeZone.getTimeZone(), Types.VARCHAR));
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
