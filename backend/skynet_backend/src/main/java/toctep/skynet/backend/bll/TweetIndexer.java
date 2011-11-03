package toctep.skynet.backend.bll;

import java.util.ArrayList;
import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetIndexer {
	
	public List<TweetKeyword> indexTweetKeywords(Tweet tweet) {
		List<TweetKeyword> tweetKeywords = new ArrayList<TweetKeyword>();
    	String filteredTweetBody = TweetFilter.filterTweet(tweet);
    	String[] keywordStrings = TweetSplitter.splitTweet(filteredTweetBody);
    	
    	for(String keywordString: keywordStrings) {
    		tweetKeywords.add(parseTweetKeyword(keywordString, tweet));
    	}
    	return tweetKeywords;
    }
    
    private TweetKeyword parseTweetKeyword(String keywordString, Tweet tweet) {
		Keyword keyword = new Keyword(keywordString);
		
    	TweetKeyword tweetKeyword = new TweetKeyword();
    	
    	tweetKeyword.setKeyword(keyword);
    	tweetKeyword.setTweet(tweet);
    	tweetKeyword.setTweetKeywordValue(keywordString);
    	
    	return tweetKeyword;
    }
}
