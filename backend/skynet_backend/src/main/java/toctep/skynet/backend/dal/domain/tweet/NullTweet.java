package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;

public class NullTweet implements ITweet {

	@Override
	public String getText() {
		return "";
	}

	@Override
	public IGeo getGeo() {
		return new NullGeo();
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
		return new NullSourceType();
	}

	@Override
	public boolean isFavorited() {
		return false;
	}

	@Override
	public ITweet getInReplyToTweetTwitter() {
		return new NullTweet();
	}

	@Override
	public IUser getInReplyToUserTwitter() {
		return new NullUser();
	}

	@Override
	public long getRetweetCount() {
		return 0;
	}

	@Override
	public Date getCreatedAt() {
		return new Date(0);
	}

	@Override
	public IPlace getPlace() {
		return new NullPlace();
	}

	@Override
	public IUser getUser() {
		return new NullUser();
	}

	@Override
	public String getCoordinates() {
		return "";
	}

}
