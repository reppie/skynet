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
	
	public boolean parse(Status status) {
		System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
        System.out.println();
        
        Tweet tweet = new Tweet();
        tweet.setText(status.getText());
        tweet.setTruncated(status.isTruncated());
        tweet.setTwitterId(status.getId());
		tweet.setFavorited(status.isFavorited());
		tweet.setInReplyToTweetTwitterId(status.getInReplyToStatusId());
		tweet.setInReplyToUserTwitterId(status.getInReplyToUserId());
		tweet.setRetweetCount(status.getRetweetCount());
		tweet.setCreatedAt(status.getCreatedAt());
		return true;
	}
	
}
