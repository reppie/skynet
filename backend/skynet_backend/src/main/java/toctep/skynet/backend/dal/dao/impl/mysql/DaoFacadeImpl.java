package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;

public class DaoFacadeImpl implements DaoFacade {
	
	private Dao userDao;
	private Dao tweetDao;
	
	public DaoFacadeImpl() {
		userDao = new UserDaoImpl();
		tweetDao = new TweetDaoImpl();
	}
	
	@Override
	public Dao getUserDao() {
		return userDao;
	}

	@Override
	public Dao getTweetDao() {
		return tweetDao;
	}

}
