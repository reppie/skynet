package toctep.skynet.backend.dal.dao;

public abstract class SourceTypeDao extends Dao {

	public static final String TABLE_NAME = "twitter_sourcetype";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
