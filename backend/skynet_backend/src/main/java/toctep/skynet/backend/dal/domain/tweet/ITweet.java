package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.domain.IDomain;
import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.sourcetype.ISourceType;
import toctep.skynet.backend.dal.domain.user.IUser;

public interface ITweet extends IDomain<Long> {

	String getText();
	IGeo getGeo();
	boolean isTruncated();
	long getTwitterId();
	ISourceType getSourceType();
	boolean isFavorited();
	ITweet getInReplyToTweetTwitter();
	IUser getInReplyToUserTwitter();
	long getRetweetCount();
	Timestamp getCreatedAt();
	IPlace getPlace();
	IUser getUser();
	String getCoordinates();
	
}
