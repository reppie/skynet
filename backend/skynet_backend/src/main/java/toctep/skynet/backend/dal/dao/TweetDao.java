package toctep.skynet.backend.dal.dao;

public abstract class TweetDao extends Dao {

	public static final String TABLE_NAME = "twitter_tweet";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
