package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.GeoType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GeoTypeDaoImpl extends GeoTypeDao{

	@Override
	public void delete(Domain domain) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		GeoType geoType = (GeoType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + geoType.getId());
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
		
		GeoType geoType = (GeoType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (text) VALUES ('" + geoType.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			geoType.setId(id);
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
	public GeoType select(long id) {
		Connection conn = MySqlUtil.getInstance().getConnection();
		
		GeoType geoType = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);			
			rs.first();
			geoType = new GeoType();
			geoType.setId(id);
			geoType.setText(rs.getString("text"));
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
		return geoType;
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

}
