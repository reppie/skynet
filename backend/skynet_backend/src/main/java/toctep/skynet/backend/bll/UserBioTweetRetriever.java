package toctep.skynet.backend.bll;

import toctep.skynet.backend.log.Log;
import twitter4j.Status;

import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public class UserBioTweetRetriever extends TweetRetriever {
	
	private twitter4j.User user;
	
	public UserBioTweetRetriever() {
		super();
	}
	
	@Override
	public void run() {
		getTwitterStream().sample();
	}
	
	@Override
	public void process(Status status) {
	
		user = status.getUser();
		
		if (TweetUtils.isDutchLanguage(status.getText(), user.getLang()) 
										|| TweetUtils.isDutchLocation(user.getLocation()) 
										|| TweetUtils.isDutchTimeZone(user.getTimeZone())) {
			super.process(status);
    	}
	}
}
