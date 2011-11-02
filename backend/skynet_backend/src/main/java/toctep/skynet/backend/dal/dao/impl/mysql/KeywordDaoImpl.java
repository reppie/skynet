package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Keyword;

import com.mysql.jdbc.Statement;

public class KeywordDaoImpl extends KeywordDao {

	@Override
	public void insert(Domain<Long> domain) {
		Keyword keyword = (Keyword) domain;
		
		String query = "INSERT INTO " + tableName + " (keyword) VALUES(?)";
		
		Param[] params = new Param[] {
			new Param(keyword.getKeyword(), Types.VARCHAR)
		};
		
		Long id = MySqlUtil.getInstance().insert(query, params);
		
		keyword.setId(id);
	}

	@Override
	public Keyword select(Long id) {
		Keyword keyword = new Keyword();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(keyword.getId(), Types.BIGINT)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);
		
		keyword.setId(id);
		try {
			keyword.setKeyword(rs.getString("keyword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return keyword;
	}

	@Override
	public void update(Domain<Long> domain) {
		searchKeyword(domain);
	}
	
	private void searchKeyword(Domain<Long> domain) {
		Keyword keyword = (Keyword) domain;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) MySqlUtil.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery("SELECT id FROM " + tableName + " WHERE keyword = '" + keyword.getKeyword() + "';");
			rs.first();
			keyword.setId(rs.getLong("id"));
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
	public void delete(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		boolean exists = false;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) MySqlUtil.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE keyword = '" + ((Keyword) domain).getKeyword() + "';");
			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			if (counter > 0) {
				exists = true;
			}
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
		
		return exists;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
