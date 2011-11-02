package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.country.Country;

public class CountryDaoImpl extends CountryDao{

	@Override
	public void insert(Domain<String> domain) {
		Country country = (Country) domain;
		
		String query = "INSERT INTO " + tableName + "(code, text) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(country.getId(), Types.VARCHAR),
			new Param(country.getText(), Types.VARCHAR)
		};
			
		MySqlUtil.getInstance().insert(query, params);
	}

	@Override
	public Country select(String id) {
		Country country = new Country();
		
		String query = "SELECT * FROM " + tableName + " WHERE code=?";
		
		Param[] params = new Param[] {
			new Param(country.getId(), Types.VARCHAR)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);
		
		country.setId(id);
		try {
			country.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return country;
	}

	@Override
	public void update(Domain<String> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<String> domain) {
		Country country = (Country) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE code = " + MySqlUtil.escape(country.getId()));
	}

	@Override
	public boolean exists(Domain<String> domain) {
		Country country = (Country) domain;
		return MySqlUtil.getInstance().exists(tableName, "code = " + MySqlUtil.escape(country.getId()));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
