package toctep.skynet.backend.test;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.TweetURLDao;
import toctep.skynet.backend.dal.dao.URLDao;
import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoConnectionImpl;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public abstract class DomainTest extends TestCase {

	private Connection conn;
	
	private DaoFacade daoFacade;
	
	protected BoundingBoxDao boundingBoxDao;
	protected BoundingBoxTypeDao boundingBoxTypeDao;
	protected CountryDao countryDao;
	protected GeoDao geoDao;
	protected GeoTypeDao geoTypeDao;
	protected HashtagDao hashtagDao;
	protected LanguageDao languageDao;
	protected PlaceDao placeDao;
	protected PlaceTypeDao placeTypeDao;
	protected SourceTypeDao sourceTypeDao;
	protected TimeZoneDao timeZoneDao;
	protected TweetContributorDao tweetContributorDao;
	protected TweetHashtagDao tweetHashtagDao;
	protected TweetDao tweetDao;
	protected TweetMentionDao tweetMentionDao;
	protected TweetURLDao tweetURLDao;
	protected URLDao urlDao;
	protected UserDao userDao;
	
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
		boundingBoxDao = daoFacade.getBoundingBoxDao();
		boundingBoxTypeDao = daoFacade.getBoundingBoxTypeDao();
		placeDao = daoFacade.getPlaceDao();
		countryDao = daoFacade.getCountryDao();
		placeTypeDao = daoFacade.getPlaceTypeDao();
		sourceTypeDao = daoFacade.getSourceTypeDao();
		geoDao = daoFacade.getGeoDao();
		geoTypeDao = daoFacade.getGeoTypeDao();
		hashtagDao = daoFacade.getHashtagDao();
		languageDao = daoFacade.getLanguageDao();
		timeZoneDao = daoFacade.getTimeZoneDao();
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
	
	@Test
	public abstract void testCreate();
	
	@Test
	public abstract void testInsert();
	
	@Test
	public abstract void testUpdate();
	
	@Test
	public abstract void testDelete();	
}
