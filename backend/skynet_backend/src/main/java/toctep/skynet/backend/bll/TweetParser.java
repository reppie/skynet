package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.jdbc.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Tweet;
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
        
        //tweetDao.insert(new Tweet(status.getText()));
		
		return true;
	}
	
}
