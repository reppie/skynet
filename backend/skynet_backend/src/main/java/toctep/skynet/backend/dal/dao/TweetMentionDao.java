package toctep.skynet.backend.dal.dao;

import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;

public abstract class TweetMentionDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_tweet_mentions";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

	public abstract List<TweetMention> select(Tweet tweet);
	
}
