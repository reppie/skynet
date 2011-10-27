package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.dao.SourceTypeDao;
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
	private SourceTypeDao sourceTypeDao;
	
	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
		boundingBoxDao = new BoundingBoxDaoImpl();
		boundingBoxTypeDao = new BoundingBoxTypeDaoImpl();
		placeDao = new PlaceDaoImpl();
		placeTypeDao = new PlaceTypeDaoImpl();
		sourceTypeDao = new SourceTypeDaoImpl();
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

}
