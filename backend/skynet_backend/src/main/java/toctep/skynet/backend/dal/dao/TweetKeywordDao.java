package toctep.skynet.backend.dal.dao;

import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;


public abstract class TweetKeywordDao extends Dao<Integer> {
	public static final String TABLE_NAME = "twitter_tweet_keywords";

	public abstract List<TweetKeyword> select(Tweet tweet);
	
}
