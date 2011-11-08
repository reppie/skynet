package toctep.skynet.backend.dal.dao;

import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;

public abstract class TweetHashtagDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_tweet_hashtags";
	
	public abstract List<TweetHashtag> select(Tweet tweet);

}
