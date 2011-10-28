package toctep.skynet.backend.dal.dao;

public abstract class TweetURLDao extends Dao {

	public static final String TABLE_NAME = "twitter_tweet_urls";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
