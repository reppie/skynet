package toctep.skynet.backend.dal.dao;

public abstract class BoundingBoxDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_boundingbox";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
}