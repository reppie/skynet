package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Tweet;
import twitter4j.Status;

public class TweetParser {
	
	private static TweetParser instance;
	private DaoFacade daoFacade;
	private TweetDao tweetDao;
	
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
	
	public boolean parse(Status tweet) {
		System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
        System.out.println();
        
        tweetDao.insertTweet(new Tweet(tweet.getText()));
		
		return true;
	}
	
}
