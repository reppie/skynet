package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.UserDao;

public class DaoFacadeImpl implements DaoFacade {
	
	private UserDao userDao;
	private TweetDao tweetDao;
	private BoundingBoxDao boundingBoxDao;
	private BoundingBoxTypeDao boundingBoxTypeDao;
	private PlaceDao placeDao;
	private CountryDao countryDao;
	private PlaceTypeDao placeTypeDao;
	
	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
		boundingBoxDao = new BoundingBoxDaoImpl();
		boundingBoxTypeDao = new BoundingBoxTypeDaoImpl();
		placeDao = new PlaceDaoImpl();
		placeTypeDao = new PlaceTypeDaoImpl();
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

	public PlaceTypeDao getPlaceTypeDao() {
		return placeTypeDao;
	}

}
