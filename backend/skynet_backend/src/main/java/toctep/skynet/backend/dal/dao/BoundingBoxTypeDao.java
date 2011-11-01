package toctep.skynet.backend.dal.dao;

public abstract class BoundingBoxTypeDao extends Dao<Long> {

	public static final String TABLE_NAME = "twitter_boundingboxtype";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}

}