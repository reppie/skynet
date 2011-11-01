package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.domain.tweet.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetIndexer {
	
	public void indexTweetKeywords(Tweet tweet) {
    	String filteredTweetBody = TweetFilter.filterTweet(tweet);
    	String[] keywordStrings = TweetSplitter.splitTweet(filteredTweetBody);
    	
    	for(String keywordString: keywordStrings) {
    		saveKeyword(keywordString, tweet);
    	}
    }
    
    private void saveKeyword(String keywordString, Tweet tweet) {
		Keyword keyword = new Keyword(keywordString);
		keyword.save();
		saveTweetKeywordRelation(keywordString, keyword, tweet);
    }
    
    private void saveTweetKeywordRelation(String keywordString, Keyword keyword, Tweet tweet) {
    	TweetKeyword tweetKeyword = new TweetKeyword();
    	    	
    	tweetKeyword.setKeyword(keyword);
    	tweetKeyword.setTweet(tweet);
    	tweetKeyword.setTweetKeywordValue(keywordString);
    	tweetKeyword.save();
    }

}
