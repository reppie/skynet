package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.domain.Keyword;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetKeyword;

public class TweetIndexer {
	
	public void indexTweetKeywords(Tweet tweet) {
    	String filteredTweetBody = TweetFilter.filterTweet(tweet);
    	String[] keywordStrings = TweetSplitter.splitTweet(filteredTweetBody);
    	
    	for(String keywordString: keywordStrings) {
    		long keywordId = getKeywordId(keywordString);
    		saveTweetKeyword(keywordString, keywordId, tweet);
    	}
    }
    
    private long getKeywordId(String keywordString) {
    	Keyword keyword = new Keyword();
    	keyword.setKeyword(keywordString.toLowerCase());
    	keyword.save();
    	
    	return keyword.getId();
    }
    
    private void saveTweetKeyword(String keywordString, long keywordId, Tweet tweet) {
    	TweetKeyword tweetKeyword = new TweetKeyword();
    	
    	tweetKeyword.setKeywordId(keywordId);
    	tweetKeyword.setTweetId(tweet.getId());
    	tweetKeyword.setTweetKeywordValue(keywordString);
    }

}
