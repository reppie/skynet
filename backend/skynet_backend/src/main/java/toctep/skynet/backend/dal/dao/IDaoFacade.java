package toctep.skynet.backend.dal.dao;

public interface IDaoFacade {

	BoundingBoxDao getBoundingBoxDao();
	BoundingBoxTypeDao getBoundingBoxTypeDao();
	CountryDao getCountryDao();
	GeoDao getGeoDao();
	GeoTypeDao getGeoTypeDao();
	HashtagDao getHashtagDao();
	LanguageDao getLanguageDao();
	PlaceDao getPlaceDao();	
	PlaceTypeDao getPlaceTypeDao();	
	SourceTypeDao getSourceTypeDao();
	TimeZoneDao getTimeZoneDao();
	TweetContributorDao getTweetContributorDao();
	TweetHashtagDao getTweetHashtagDao();
	TweetMentionDao getTweetMentionDao();
	TweetDao getTweetDao();
	TweetUrlDao getTweetUrlDao();
	UrlDao getUrlDao();
	UserDao getUserDao();
	TweetKeywordDao getTweetKeywordDao();
	KeywordDao getKeywordDao();
	
}
