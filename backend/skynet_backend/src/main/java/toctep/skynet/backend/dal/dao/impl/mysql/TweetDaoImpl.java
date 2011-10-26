package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.Tweet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TweetDaoImpl implements TweetDao {

	@Override
	public void delete(Domain tweet) {
		Connection conn = DaoConnectionImpl.getInstance().getConnection();
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(
					"DELETE FROM twitter_tweet" +
					"WHERE id=" +	tweet.getId());
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
	public void insert(Domain tweet) {
		Connection conn = DaoConnectionImpl.getInstance().getConnection();
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(
					"INSERT INTO twitter_tweet" +
						"(text)" +
					"VALUES " +
						"('" + tweet.getText() + "')");
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
	public void update(Domain tweet) {
		// TODO Auto-generated method stub
		
	}

}
