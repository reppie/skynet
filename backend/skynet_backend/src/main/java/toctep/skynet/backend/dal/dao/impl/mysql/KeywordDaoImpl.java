package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.DomainLongPk;
import toctep.skynet.backend.dal.domain.Keyword;

public class KeywordDaoImpl extends KeywordDao {

	@Override
	public void insert(Domain domain) {
		Keyword keyword = (Keyword) domain;
		
		int id = MySqlUtil.getInstance().insert(
				"INSERT INTO " + tableName + " (keyword) " +
				"VALUES ('" + keyword.getKeyword() + "');" 
				);
		
		keyword.setId(id);
	}

	@Override
	public DomainLongPk select(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain domain) {
		//we don't update keywords
	}

	@Override
	public void delete(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Domain domain) {
		boolean exists = false;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) MySqlUtil.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName + " WHERE '" + ((Keyword) domain).getKeyword() + "';");
			if (rs.first()) {
				exists = true;
			} else if (rs.getFetchSize() > 1) {
				System.out.println("ER IS IETS FOUT!!");
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
		// TODO Auto-generated method stub
		return 0;
	}

}
