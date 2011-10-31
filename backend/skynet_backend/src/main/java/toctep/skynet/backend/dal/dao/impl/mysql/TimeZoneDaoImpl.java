package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.TimeZone;

public class TimeZoneDaoImpl extends TimeZoneDao {

	@Override
	public void insert(Domain domain) {
		TimeZone timeZone = (TimeZone) domain;
		
		int id = MySqlUtil.getInstance().insert(
			"INSERT INTO " + tableName + " (utc_offset, time_zone) " +
			"VALUES (" + timeZone.getUtcOffset() + ", '" 
					   + timeZone.getTimeZone() + "')"
		);
		
		timeZone.setId(id);
	}

	@Override
	public TimeZone select(long id) {
		TimeZone timeZone = new TimeZone();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT * FROM " + tableName + " WHERE id = " + id);
		
		timeZone.setId(id);
		
		try {
			timeZone.setUtcOffset(rs.getInt("utc_offset"));
			timeZone.setTimeZone((rs.getString("time_zone")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return timeZone;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void delete(Domain domain) {
		TimeZone timeZone = (TimeZone) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + timeZone.getId());	
	}
	
	@Override
	public boolean exists(Domain domain) {
		TimeZone timeZone = (TimeZone) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + timeZone.getId());
	}
	
	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
}
