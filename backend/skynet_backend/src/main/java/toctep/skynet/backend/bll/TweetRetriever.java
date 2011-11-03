package toctep.skynet.backend.bll;

import toctep.skynet.backend.Skynet;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TweetRetriever implements Runnable {

	private TweetParser tweetParser;
	private TwitterStream twitterStream;
	
	public TweetRetriever() {
	    initialize();
	}
	
	private void initialize() {
		tweetParser = TweetParser.getInstance();
		
		StatusListener statusListener = new StatusListener() {
	        public void onStatus(Status status) {
	            tweetParser.parse(status);
	        }
	
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) { }
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) { }
	        public void onScrubGeo(long userId, long upToStatusId) { }
	
	        public void onException(Exception e) {
	            Skynet.log.error(e.getMessage(), e);
	        }
	    };
	    
	    twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(statusListener);
	}

	@Override
	public void run() {
		// TODO Create a "pretty" way of managing filters 
	    double[][] coords = { {3.39, 51.17}, {7.29, 53.51} }; // Nederland
	    //double[][] coords = { {6.19, 53.09}, {7.22, 53.51} }; // Provincie Groningen
	    //double[][] coords = { {6.45, 53.16}, {6.65, 53.26} }; // Groningen
	    //double[][] coords = { {6.52, 53.23}, {6.55, 53.25} }; // Zernike Complex
	    
	    twitterStream.filter(new FilterQuery(0, new long[] { 397147205 }, null, coords));
	}
	
}
