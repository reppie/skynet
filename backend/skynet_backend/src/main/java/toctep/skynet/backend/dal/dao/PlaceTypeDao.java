package toctep.skynet.backend.dal.dao;

public abstract class PlaceTypeDao extends Dao {

	public static final String TABLE_NAME = "twitter_placetype";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}
