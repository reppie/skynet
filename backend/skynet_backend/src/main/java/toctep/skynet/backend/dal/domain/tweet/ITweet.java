package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.SourceType;
import toctep.skynet.backend.dal.domain.User;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.place.Place;

public interface ITweet {

	public String getText();
	public Geo getGeo();
	public boolean isTruncated();
	public long getTwitterId();
	public SourceType getSourceType();
	public boolean isFavorited();
	public Tweet getInReplyToTweetTwitter();
	public User getInReplyToUserTwitter();
	public long getRetweetCount();
	public Date getCreatedAt();
	public Place getPlace();
	public User getUser();
	public String getCoordinates();
	
}
