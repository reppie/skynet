package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.hashtag.IHashtag;

public abstract class HashtagDao extends Dao<Integer> {

	public static final String TABLE_NAME = "twitter_hashtag";
	
	public abstract IHashtag select(String text);

}