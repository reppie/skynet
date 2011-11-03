package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;

public class TimeZoneDaoImpl extends TimeZoneDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TimeZone timeZone = (TimeZone) domain;
		
		String query = "INSERT INTO " + tableName + "(utc_offset, time_zone) VALUES(?, ?)";
		
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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().selectRecord(query, params);
		
		timeZone.setId(id);
		timeZone.setUtcOffset((Integer) record.get(1));
		timeZone.setTimeZone((String) record.get(2));
		
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
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(timeZone.getId(), Types.INTEGER) }
		);
	}
	
	@Override
	public boolean exists(Domain<Integer> domain) {
		TimeZone timeZone = (TimeZone) domain;
		return this.exists(timeZone.getId());
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id=" + id);
	}
	
	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
}
