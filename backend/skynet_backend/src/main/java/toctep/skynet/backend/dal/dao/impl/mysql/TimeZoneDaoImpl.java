package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.TimeZone;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TimeZoneDaoImpl extends TimeZoneDao {

	@Override
	public void delete(Domain domain) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		TimeZone timeZone = (TimeZone) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + timeZone.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	@Override
	public void insert(Domain domain) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		TimeZone timeZone = (TimeZone) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (utc_offset, time_zone) " +
					"VALUES (" + timeZone.getUtcOffset() + ", '" 
								+ timeZone.getTimeZone() + "')",					
					Statement.RETURN_GENERATED_KEYS
				);
			timeZone.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public TimeZone select(long id) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		TimeZone timeZone = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);
			rs.first();
			timeZone = new TimeZone();
			timeZone.setId(id);
			timeZone.setUtcOffset(rs.getInt("utc_offset"));
			timeZone.setTimeZone((rs.getString("time_zone")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return timeZone;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
