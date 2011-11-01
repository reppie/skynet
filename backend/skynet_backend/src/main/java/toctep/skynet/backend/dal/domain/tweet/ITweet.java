package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.IDomain;
import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.user.IUser;

public interface ITweet extends IDomain<Long> {

	public String getText();
	public IGeo getGeo();
	public boolean isTruncated();
	public long getTwitterId();
	public ISourceType getSourceType();
	public boolean isFavorited();
	public ITweet getInReplyToTweetTwitter();
	public IUser getInReplyToUserTwitter();
	public long getRetweetCount();
	public Date getCreatedAt();
	public IPlace getPlace();
	public IUser getUser();
	public String getCoordinates();
	
}
