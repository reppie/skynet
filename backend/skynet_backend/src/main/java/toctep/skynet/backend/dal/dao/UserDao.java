package toctep.skynet.backend.dal.dao;

public abstract class UserDao extends Dao {

	public static final String TABLE_NAME = "twitter_user";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
