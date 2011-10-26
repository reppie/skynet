package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Tweet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TweetDaoImpl implements Dao {
	
	@Override
	public void insert(Domain domain) {
		Connection conn = DaoConnectionImpl.getInstance().getConnection();
		
		Tweet tweet = (Tweet) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			int id = stmt.executeUpdate(
				"INSERT INTO twitter_tweet (text) VALUES (\"" + ((Tweet) tweet).getText() + "\")",
				Statement.RETURN_GENERATED_KEYS
			);
			tweet.setId(id);
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
	public Tweet select(int id) {
		Connection conn = DaoConnectionImpl.getInstance().getConnection();
		
		Tweet tweet = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT id FROM twitter_tweet WHERE id = " + id);
			rs.first();
			tweet = new Tweet(rs.getInt("id"), rs.getString("text"));
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
		
		return tweet;
	}

	@Override
	public void update(Domain domain) {
		// TODO
	}
	
	@Override
	public void delete(Domain domain) {
		Connection conn = DaoConnectionImpl.getInstance().getConnection();
		
		Tweet tweet = (Tweet) domain;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("DELETE FROM twitter_tweet WHERE id=" +	tweet.getId());
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

}
