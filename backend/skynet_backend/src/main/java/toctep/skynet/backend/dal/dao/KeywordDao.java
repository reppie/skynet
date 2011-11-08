package toctep.skynet.backend.dal.dao;

public abstract class KeywordDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_keyword";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
	
	public abstract Integer select(String keyword);
	
}
