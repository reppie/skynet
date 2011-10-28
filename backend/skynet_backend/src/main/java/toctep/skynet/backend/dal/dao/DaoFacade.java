package toctep.skynet.backend.dal.dao;

public interface DaoFacade {

	// TODO, make this a singleton!
	
	public BoundingBoxDao getBoundingBoxDao();
	public BoundingBoxTypeDao getBoundingBoxTypeDao();
	public CountryDao getCountryDao();
	public GeoDao getGeoDao();
	public GeoTypeDao getGeoTypeDao();
	public HashtagDao getHashtagDao();
	public LanguageDao getLanguageDao();
	public PlaceDao getPlaceDao();	
	public PlaceTypeDao getPlaceTypeDao();	
	public SourceTypeDao getSourceTypeDao();
	public TimeZoneDao getTimeZoneDao();
	public TweetContributorDao getTweetContributorDao();
	public TweetHashtagDao getTweetHashtagDao();
	public TweetMentionDao getTweetMentionDao();
	public TweetDao getTweetDao();
	public TweetUrlDao getTweetUrlDao();
	public UrlDao getUrlDao();
	public UserDao getUserDao();
	public TweetKeywordDao getTweetKeywordDao();
	public KeywordDao getKeywordDao();
	
}
