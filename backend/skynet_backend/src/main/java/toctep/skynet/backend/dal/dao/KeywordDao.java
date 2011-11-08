package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.keyword.IKeyword;

public abstract class KeywordDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_keyword";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
	
	public abstract IKeyword select(String keyword);
	
}
