package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.keyword.IKeyword;

public abstract class KeywordDao implements IDao<Integer> {

	public static final String TABLE_NAME = "twitter_keyword";
	
	public abstract IKeyword select(String keyword);
	
}
