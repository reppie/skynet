package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Keyword;

import com.mysql.jdbc.Statement;

public class KeywordDaoImpl extends KeywordDao {

	@Override
	public void insert(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;
		
		String query = "INSERT INTO " + tableName + " (keyword) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(keyword.getKeyword(), Types.VARCHAR)
		};
		
		int id = MySqlUtil.getInstance().insert(query, params);
		
		keyword.setId(id);
	}

	@Override
	public Keyword select(Integer id) {
		Keyword keyword = new Keyword();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.INTEGER)
		};
		
		List<Object> record = MySqlUtil.getInstance().selectRecord(query, params);
		
		keyword.setId(id);
		keyword.setKeyword((String) record.get(1));
		
		return keyword;
	}

	@Override
	public void update(Domain<Integer> domain) {
		searchKeyword(domain);
	}
	
	private void searchKeyword(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) MySqlUtil.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery("SELECT id FROM " + tableName + " WHERE keyword = '" + keyword.getKeyword() + "';");
			rs.first();
			keyword.setId(rs.getInt("id"));
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
	}

	@Override
	public void delete(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;	
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(keyword.getId(), Types.INTEGER) }
		);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		Keyword keyword = (Keyword) domain;
		return this.exists(keyword.getId());
	}
	
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
