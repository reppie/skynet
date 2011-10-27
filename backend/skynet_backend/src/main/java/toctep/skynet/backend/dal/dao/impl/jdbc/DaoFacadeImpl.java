package toctep.skynet.backend.dal.dao.impl.jdbc;

import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.UserDao;

public class DaoFacadeImpl implements DaoFacade {
	
	private UserDao userDao;
	private TweetDao tweetDao;
	
	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
	}
	
	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public TweetDao getTweetDao() {
		return tweetDao;
	}

}
