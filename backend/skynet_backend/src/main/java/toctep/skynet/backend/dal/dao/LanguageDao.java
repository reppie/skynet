package toctep.skynet.backend.dal.dao;

public abstract class LanguageDao extends DaoLongPk {

	public static final String TABLE_NAME = "twitter_language";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}