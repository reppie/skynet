package toctep.skynet.backend.test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.jdbc.DaoConnectionImpl;
import toctep.skynet.backend.dal.dao.impl.jdbc.DaoFacadeImpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public abstract class DomainTest {

	private Connection conn;
	
	private DaoFacade daoFacade;
	protected Dao userDao;
	protected Dao tweetDao;
	
	@Before
	public void setUp() {
		conn = DaoConnectionImpl.getInstance(
				"mysql",
				"localhost",
				"skynet_test",
				"skynet",
				"asdasd"
			).getConnection();
		
		emptyDatabase();
		
		daoFacade = new DaoFacadeImpl();
		userDao = daoFacade.getUserDao();
		tweetDao = daoFacade.getTweetDao();
	}

	@After
	public void tearDown() {
		emptyDatabase();
	}
	
	public void emptyDatabase() {
		try {
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeQuery("TRUNCATE TABLE twitter_boundingbox");
			stmt.executeQuery("TRUNCATE TABLE twitter_boundingboxtype");
			stmt.executeQuery("TRUNCATE TABLE twitter_coordinates");
			stmt.executeQuery("TRUNCATE TABLE twitter_coordinatestype");
			stmt.executeQuery("TRUNCATE TABLE twitter_country");
			stmt.executeQuery("TRUNCATE TABLE twitter_geo");
			stmt.executeQuery("TRUNCATE TABLE twitter_geotype");
			stmt.executeQuery("TRUNCATE TABLE twitter_hashtag");
			stmt.executeQuery("TRUNCATE TABLE twitter_language");
			stmt.executeQuery("TRUNCATE TABLE twitter_place");
			stmt.executeQuery("TRUNCATE TABLE twitter_placetype");
			stmt.executeQuery("TRUNCATE TABLE twitter_sourcetype");
			stmt.executeQuery("TRUNCATE TABLE twitter_timezone");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweet");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweetindex");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweet_contributors");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweet_hashtags");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweet_mentions");
			stmt.executeQuery("TRUNCATE TABLE twitter_tweet_urls");
			stmt.executeQuery("TRUNCATE TABLE twitter_url");
			stmt.executeQuery("TRUNCATE TABLE twitter_user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
