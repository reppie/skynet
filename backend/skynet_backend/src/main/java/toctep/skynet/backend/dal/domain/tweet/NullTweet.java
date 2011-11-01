package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.SourceType;
import toctep.skynet.backend.dal.domain.User;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.place.Place;

public class NullTweet implements ITweet {

	@Override
	public String getText() {
		return "";
	}

	@Override
	public Geo getGeo() {
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
	public SourceType getSourceType() {
		return new NullSourceType()
	}

	@Override
	public boolean isFavorited() {
		return false;
	}

	@Override
	public long getInReplyToTweetTwitterId() {
		return 0;
	}

	@Override
	public long getInReplyToUserTwitterId() {
		return 0;
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
	public Place getPlace() {
		return new NullPlace();
	}

	@Override
	public User getUser() {
		return NullUser();
	}

	@Override
	public String getCoordinates() {
		return "";
	}

}
