package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.user.IUser;

public abstract class UserDao implements IDao<Long> {

	public static final String TABLE_NAME = "twitter_user";
	
	public abstract IUser select(String screenName);

}
