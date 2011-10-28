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
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.TweetURLDao;
import toctep.skynet.backend.dal.dao.UserDao;

public class DaoFacadeImpl implements DaoFacade {
	
	private UserDao userDao;
	private TweetDao tweetDao;
	private BoundingBoxDao boundingBoxDao;
	private BoundingBoxTypeDao boundingBoxTypeDao;
	private PlaceDao placeDao;
	private CountryDao countryDao;
	private PlaceTypeDao placeTypeDao;
	private SourceTypeDao sourceTypeDao;
	private GeoDao geoDao;
	private GeoTypeDao geoTypeDao;
	private HashtagDao hashtagDao;
	private TweetURLDao tweetURLDao;
	private TweetMentionDao tweetMentionDao;
	private LanguageDao languageDao;
	private TimeZoneDao timeZoneDao;

	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
		boundingBoxDao = new BoundingBoxDaoImpl();
		boundingBoxTypeDao = new BoundingBoxTypeDaoImpl();
		placeDao = new PlaceDaoImpl();
		placeTypeDao = new PlaceTypeDaoImpl();
		sourceTypeDao = new SourceTypeDaoImpl();
		countryDao = new CountryDaoImpl();
		geoDao = new GeoDaoImpl();
		geoTypeDao = new GeoTypeDaoImpl();
		hashtagDao = new HashtagDaoImpl();
		tweetURLDao = new TweetURLDaoImpl();
		languageDao = new LanguageDaoImpl();
		timeZoneDao = new TimeZoneDaoImpl();
	}
	
	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public TweetDao getTweetDao() {
		return tweetDao;
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
	public PlaceDao getPlaceDao() {
		return placeDao;
	}

	@Override
	public CountryDao getCountryDao() {
		return countryDao;
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
	public TweetURLDao getTweetURLDao() {
		return tweetURLDao;
	}

	@Override
	public TweetMentionDao getTweetMentionDao() {
		return tweetMentionDao;
	}
	
	@Override
	public LanguageDao getLanguageDao() {
		return languageDao;
	}	

	@Override
	public TimeZoneDao getTimeZoneDao() {
		return timeZoneDao;
	}
}
