package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Domain;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CountryDaoImpl extends CountryDao{

	@Override
	public void delete(Domain domain) {
		Connection conn = (Connection) this.getConnection();
		
		Country country = (Country) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + country.getId());
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
		
		Country country = (Country) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
					"INSERT INTO " + tableName + " (code, text) " +
					"VALUES ('" + country.getCode() + "', '" + country.getText() + "')",
					Statement.RETURN_GENERATED_KEYS
				);
			country.setId(id);
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
	public Country select(long id) {
		Connection conn = (Connection) this.getConnection();
		
		Country country = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);			
			rs.first();
			country = new Country();
			country.setId(id);
			country.setText(rs.getString("code"));
			country.setText(rs.getString("text"));
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
		return country;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}
}
