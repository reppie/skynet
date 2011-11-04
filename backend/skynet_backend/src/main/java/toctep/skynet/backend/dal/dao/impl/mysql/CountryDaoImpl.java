package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.country.Country;

public class CountryDaoImpl extends CountryDao {

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
			new Param(id, Types.VARCHAR)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		country.setId(id);
		country.setText((String) row.get("text"));
		
		return country;
	}

	@Override
	public void update(Domain<String> domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Domain<String> domain) {
		Country country = (Country) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE code=?",
			new Param[] { new Param(country.getId(), Types.VARCHAR) }
		);
	}

	@Override
	public boolean exists(Domain<String> domain) {
		Country country = (Country) domain;
		return MySqlUtil.getInstance().exists(tableName, "text", new Param(country.getText(), Types.VARCHAR));
	}
	
	@Override
	public boolean exists(String id) {
		return MySqlUtil.getInstance().exists(tableName, "code", new Param(id, Types.VARCHAR));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}
	
}
