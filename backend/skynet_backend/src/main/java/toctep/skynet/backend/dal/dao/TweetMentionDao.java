package toctep.skynet.backend.dal.dao;

public abstract class TweetMentionDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_tweet_mentions";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
