package toctep.skynet.backend.dal.dao;

public abstract class TweetHashtagDao extends Dao<Long> {

	public static final String TABLE_NAME = "twitter_tweet_hashtags";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
