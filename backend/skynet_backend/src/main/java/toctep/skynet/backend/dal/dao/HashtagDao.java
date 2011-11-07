package toctep.skynet.backend.dal.dao;

public abstract class HashtagDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_hashtag";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
	
	public abstract Integer select(String text);

}