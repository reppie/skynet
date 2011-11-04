package toctep.skynet.backend.bll;

import java.util.ArrayList;
import java.util.List;

import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;

public class TweetIndexer {
	
	public List<Keyword> indexTweetKeywords(Tweet tweet) {
		List<Keyword> tweetKeywords = new ArrayList<Keyword>();
    	String filteredTweetBody = TweetFilter.filterTweet(tweet);
    	String[] keywordStrings = TweetSplitter.splitTweet(filteredTweetBody);
    	
    	for(String keywordString: keywordStrings) {
    		tweetKeywords.add(new Keyword(keywordString));
    	}
    	
    	return tweetKeywords;
    }
    
}
