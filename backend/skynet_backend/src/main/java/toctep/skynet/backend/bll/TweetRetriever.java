package toctep.skynet.backend.bll;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TweetRetriever implements Runnable {

	private TweetParser tweetParser;
	private StatusListener statusListerner;
	private TwitterStream twitterStream;
	
	public TweetRetriever() {
	    Initialize();
	}
	
	private void Initialize() {
		// Disable twitter4j logging
		System.setProperty ("twitter4j.loggerFactory", "twitter4j.internal.logging.NullLoggerFactory"); 
		
		tweetParser = TweetParser.getInstance();
		
		statusListerner = new StatusListener() {
	        public void onStatus(Status status) {
	            tweetParser.parse(status);
	        }
	
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	            System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
	        }
	
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	            System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
	        }
	
	        public void onScrubGeo(long userId, long upToStatusId) {
	            System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
	        }
	
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
	    };
	    
	    twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(statusListerner);
	}

	@Override
	public void run() {
		// TODO Filters beheren
	    double[][] coords = { {3.39, 51.17}, {7.29, 53.51} }; // Nederland
	    //double[][] coords = { {6.19, 53.09}, {7.22, 53.51} }; // Provincie Groningen
	    //double[][] coords = { {6.45, 53.16}, {6.65, 53.26} }; // Groningen
	    //double[][] coords = { {6.52, 53.23}, {6.55, 53.25} }; // Zernike Complex
	    
	    twitterStream.filter(new FilterQuery(0, /*new long[] { 397147205 }*/null, null, coords));
	}
	
}
