package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.PlaceType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PlaceTypeDaoImpl extends PlaceTypeDao {

	@Override
	public void delete(Domain domain) {
		Connection conn = (Connection) this.getConnection();
		
		PlaceType placeType = (PlaceType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + placeType.getId());
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
		Connection conn = (Connection) this.getConnection();
		
		PlaceType placeType = (PlaceType) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (text) VALUES ('" + placeType.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			placeType.setId(id);
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
	public PlaceType select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		PlaceType placeType = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);			
			rs.first();
			placeType = new PlaceType();
			placeType.setId(id);
			placeType.setText(rs.getString("text"));
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
		return placeType;
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
