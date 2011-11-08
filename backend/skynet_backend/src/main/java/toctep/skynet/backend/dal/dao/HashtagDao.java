package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.hashtag.IHashtag;

public abstract class HashtagDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_hashtag";
	
	@Override
	protected void setTableName() {
		this.tableName = TABLE_NAME;
	}
	
	public abstract IHashtag select(String text);

}