package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.IUser;

public abstract class TweetUser extends Domain<Integer> {

	private ITweet tweet;
	private IUser user;
	
	public TweetUser() {
		super();
	}
	
	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}
	
	@Override
	public void save() {
		if (((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
		}
		
		user.save();
		
		super.save();
	}
	
}
