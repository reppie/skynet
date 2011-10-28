package toctep.skynet.backend.dal.dao;

public abstract class GeoDao extends DaoLongPk {

	public static final String TABLE_NAME = "twitter_geo";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}