package toctep.skynet.backend.bll;

import twitter4j.Status;

public class TweetParser {
	
	private static TweetParser instance;
	
	private TweetParser() {
		
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
		
		return true;
	}
	
}
