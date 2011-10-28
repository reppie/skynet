package toctep.skynet.backend.test.dal;

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
import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.dao.UrlDao;
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
	protected TweetUrlDao tweetUrlDao;
	protected UrlDao urlDao;
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
		
		boundingBoxDao = daoFacade.getBoundingBoxDao();
		boundingBoxTypeDao = daoFacade.getBoundingBoxTypeDao();
		countryDao = daoFacade.getCountryDao();
		geoDao = daoFacade.getGeoDao();
		geoTypeDao = daoFacade.getGeoTypeDao();
		hashtagDao = daoFacade.getHashtagDao();
		tweetUrlDao = daoFacade.getTweetUrlDao();
		tweetMentionDao = daoFacade.getTweetMentionDao();
		languageDao = daoFacade.getLanguageDao();
		placeDao = daoFacade.getPlaceDao();
		placeTypeDao = daoFacade.getPlaceTypeDao();
		sourceTypeDao = daoFacade.getSourceTypeDao();
		timeZoneDao = daoFacade.getTimeZoneDao();
		tweetContributorDao = daoFacade.getTweetContributorDao();
		tweetHashtagDao = daoFacade.getTweetHashtagDao();
		tweetDao = daoFacade.getTweetDao();
		tweetUrlDao = daoFacade.getTweetUrlDao();
		urlDao = daoFacade.getUrlDao();
		userDao = daoFacade.getUserDao();
	}

	@After
	public void tearDown() {
		emptyDatabase();
	}
	
	public void emptyDatabase() {
		try {
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeQuery("TRUNCATE TABLE " + BoundingBoxDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + BoundingBoxTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE twitter_coordinates"); // TODO
			stmt.executeQuery("TRUNCATE TABLE twitter_coordinatestype"); // TODO
			stmt.executeQuery("TRUNCATE TABLE " + CountryDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + GeoDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + GeoTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + HashtagDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + LanguageDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + PlaceDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + PlaceTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + SourceTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TimeZoneDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE twitter_tweetindex"); // TODO
			stmt.executeQuery("TRUNCATE TABLE " + TweetContributorDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetHashtagDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetMentionDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetUrlDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + UrlDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + UserDao.TABLE_NAME);
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
