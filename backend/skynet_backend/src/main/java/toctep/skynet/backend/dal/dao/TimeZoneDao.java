package toctep.skynet.backend.dal.dao;

public abstract class TimeZoneDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_timezone";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
