package toctep.skynet.backend.dal.dao;

public abstract class CountryDao extends Dao {

	public static final String TABLE_NAME = "twitter_country";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}