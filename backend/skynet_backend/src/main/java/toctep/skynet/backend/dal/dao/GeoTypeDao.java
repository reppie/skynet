package toctep.skynet.backend.dal.dao;

public abstract class GeoTypeDao extends Dao {

	public static final String TABLE_NAME = "twitter_geotype";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}