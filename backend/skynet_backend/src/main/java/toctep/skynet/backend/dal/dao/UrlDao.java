package toctep.skynet.backend.dal.dao;

public abstract class UrlDao extends DaoStringPk {

	public static final String TABLE_NAME = "twitter_url";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}