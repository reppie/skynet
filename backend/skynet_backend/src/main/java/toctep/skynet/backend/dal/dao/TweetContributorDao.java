package toctep.skynet.backend.dal.dao;

public abstract class TweetContributorDao extends Dao {

	public static final String TABLE_NAME = "twitter_tweet_contributors";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
