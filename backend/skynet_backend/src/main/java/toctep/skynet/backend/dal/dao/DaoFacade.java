package toctep.skynet.backend.dal.dao;

public interface DaoFacade {

	public UserDao getUserDao();
	public TweetDao getTweetDao();
	public BoundingBoxDao getBoundingBoxDao();
	public BoundingBoxTypeDao getBoundingBoxTypeDao();
	public PlaceDao getPlaceDao();	
	public CountryDao getCountryDao();
	public PlaceTypeDao getPlaceTypeDao();	
	public SourceTypeDao getSourceTypeDao();
	public GeoDao getGeoDao();
	public GeoTypeDao getGeoTypeDao();
	public HashtagDao getHashtagDao();
	public LanguageDao getLanguageDao();
}
