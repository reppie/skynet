package toctep.skynet.backend.dal.dao.impl.mysql;

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

public class DaoFacadeImpl implements DaoFacade {
	
	private BoundingBoxDao boundingBoxDao;
	private BoundingBoxTypeDao boundingBoxTypeDao;
	private CountryDao countryDao;
	private GeoDao geoDao;
	private GeoTypeDao geoTypeDao;
	private HashtagDao hashtagDao;
	private LanguageDao languageDao;
	private PlaceDao placeDao;
	private PlaceTypeDao placeTypeDao;
	private SourceTypeDao sourceTypeDao;
	private TimeZoneDao timeZoneDao;
	private TweetContributorDao tweetContributorDao;
	private TweetHashtagDao tweetHashtagDao;
	private TweetMentionDao tweetMentionDao;
	private TweetDao tweetDao;
	private TweetUrlDao tweetUrlDao;
	private UrlDao urlDao;
	private UserDao userDao;
	
	public DaoFacadeImpl() {
		boundingBoxDao = new BoundingBoxDaoImpl();
		boundingBoxTypeDao = new BoundingBoxTypeDaoImpl();
		countryDao = new CountryDaoImpl();
		geoDao = new GeoDaoImpl();
		geoTypeDao = new GeoTypeDaoImpl();
		hashtagDao = new HashtagDaoImpl();
		languageDao = new LanguageDaoImpl();
		placeDao = new PlaceDaoImpl();
		placeTypeDao = new PlaceTypeDaoImpl();
		sourceTypeDao = new SourceTypeDaoImpl();
		timeZoneDao = new TimeZoneDaoImpl();
		tweetContributorDao = new TweetContributorDaoImpl();
		tweetHashtagDao = new TweetHashtagDaoImpl();
		tweetMentionDao = new TweetMentionDaoImpl();
		tweetDao = new TweetDaoImpl();
		tweetUrlDao = new TweetUrlDaoImpl();
		urlDao = new UrlDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	@Override
	public BoundingBoxDao getBoundingBoxDao() {
		return boundingBoxDao;
	}

	@Override
	public BoundingBoxTypeDao getBoundingBoxTypeDao() {
		return boundingBoxTypeDao;
	}
	
	@Override
	public CountryDao getCountryDao() {
		return countryDao;
	}
	
	@Override
	public GeoDao getGeoDao() {
		return geoDao;
	}

	@Override
	public GeoTypeDao getGeoTypeDao() {
		return geoTypeDao;
	}

	@Override
	public HashtagDao getHashtagDao() {
		return hashtagDao;
	}
	
	@Override
	public LanguageDao getLanguageDao() {
		return languageDao;
	}

	@Override
	public PlaceDao getPlaceDao() {
		return placeDao;
	}

	@Override
	public PlaceTypeDao getPlaceTypeDao() {
		return placeTypeDao;
	}
	
	@Override
	public SourceTypeDao getSourceTypeDao() {
		return sourceTypeDao;
	}

	@Override
	public TimeZoneDao getTimeZoneDao() {
		return timeZoneDao;
	}
	
	@Override
	public TweetContributorDao getTweetContributorDao() {
		return tweetContributorDao;
	}

	@Override
	public TweetHashtagDao getTweetHashtagDao() {
		return tweetHashtagDao;
	}
	
	@Override
	public TweetMentionDao getTweetMentionDao() {
		return tweetMentionDao;
	}
	
	@Override
	public TweetDao getTweetDao() {
		return tweetDao;
	}
	
	@Override
	public TweetUrlDao getTweetUrlDao() {
		return tweetUrlDao;
	}

	@Override
	public UrlDao getUrlDao() {
		return urlDao;
	}
	
	@Override
	public UserDao getUserDao() {
		return userDao;
	}
}
