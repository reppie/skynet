package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import twitter4j.Status;

public class TweetParser {
	
	private static TweetParser instance;
	private DaoFacade daoFacade;
	private Dao tweetDao;
	
	private TweetParser() {
		daoFacade = new DaoFacadeImpl();
		tweetDao = daoFacade.getTweetDao();
	}
	
	public static TweetParser getInstance() {
		if (instance == null) {
			instance = new TweetParser();
		}
		return instance;
	}
	
	public boolean parse(Status status) {
		System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
        System.out.println();
		
		return true;
	}
	
}
