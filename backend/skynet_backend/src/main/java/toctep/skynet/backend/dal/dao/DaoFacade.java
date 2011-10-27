package toctep.skynet.backend.dal.dao;

public interface DaoFacade {

	public UserDao getUserDao();
	public TweetDao getTweetDao();
	public BoundingBoxDao getBoundingBoxDao();
	public BoundingBoxTypeDao getBoundingBoxTypeDao();
	public PlaceDao getPlaceDao();	
	public CountryDao getCountryDao();
	public PlaceTypeDao getPlaceTypeDao();	
}
