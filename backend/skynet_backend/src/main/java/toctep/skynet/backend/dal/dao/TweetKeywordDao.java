package toctep.skynet.backend.dal.dao;


public abstract class TweetKeywordDao extends DaoLongPk {
	public static final String TABLE_NAME = "twitter_tweet_keywords";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
