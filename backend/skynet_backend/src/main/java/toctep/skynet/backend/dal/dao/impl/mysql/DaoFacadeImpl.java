package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.UserDao;

public class DaoFacadeImpl implements DaoFacade {
	
	private UserDao userDao;
	private TweetDao tweetDao;
	private BoundingBoxDao boundingBoxDao;
	private BoundingBoxTypeDao boundingBoxTypeDao;
	
	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
		boundingBoxDao = new BoundingBoxDaoImpl();
		boundingBoxTypeDao = new BoundingBoxTypeDaoImpl();
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

}
