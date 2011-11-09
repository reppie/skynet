package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.sourcetype.ISourceType;
import toctep.skynet.backend.dal.domain.sourcetype.NullSourceType;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;

public final class NullTweet implements ITweet {

	private static NullTweet instance;
	
	public static NullTweet getInstance() {
		if (instance == null) {
			instance = new NullTweet();
		}
		return instance;
	}
	
	private NullTweet() { }
	
	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

	@Override
	public IGeo getGeo() {
		return NullGeo.getInstance();
	}

	@Override
	public boolean isTruncated() {
		return false;
	}

	@Override
	public long getTwitterId() {
		return 0;
	}

	@Override
	public ISourceType getSourceType() {
		return NullSourceType.getInstance();
	}

	@Override
	public boolean isFavorited() {
		return false;
	}

	@Override
	public ITweet getInReplyToTweetTwitter() {
		return NullTweet.getInstance();
	}

	@Override
	public IUser getInReplyToUserTwitter() {
		return NullUser.getInstance();
	}

	@Override
	public long getRetweetCount() {
		return 0;
	}

	@Override
	public Timestamp getCreatedAt() {
		return new Timestamp(0);
	}

	@Override
	public IPlace getPlace() {
		return NullPlace.getInstance();
	}

	@Override
	public IUser getUser() {
		return NullUser.getInstance();
	}

	@Override
	public String getCoordinates() {
		return "";
	}

	@Override
	public void save() {}

}
