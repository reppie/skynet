package toctep.skynet.backend.dal.dao;

public abstract class PlaceDao extends Dao<String> {

	public static final String TABLE_NAME = "twitter_place";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
