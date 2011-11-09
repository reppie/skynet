package toctep.skynet.backend.dal.dao;

import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;

public abstract class TweetUrlDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_tweet_urls";
	
	public abstract List<TweetUrl> select(Tweet tweet);

}
