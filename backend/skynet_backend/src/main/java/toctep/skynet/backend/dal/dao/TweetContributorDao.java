package toctep.skynet.backend.dal.dao;

import java.util.List;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;

public abstract class TweetContributorDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_tweet_contributors";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
	
	public abstract List<TweetContributor> select(Tweet tweet);
}
