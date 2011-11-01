package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.DomainLongPk;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.User;

public class Tweet extends DomainLongPk implements ITweet {

	private String text;
	private Geo geo;
	private boolean truncated;
	private long twitterId;
	private SourceType sourceType;
	private boolean favorited;
	private Tweet inReplyToTweetTwitter;
	private User inReplyToUserTwitter;
	private long retweetCount;
	private Date createdAt;
	private Place place;
	private User user;
	private String coordinates;
	
	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public boolean isTruncated() {
		return truncated;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	@Override
	public long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(long twitterId) {
		this.twitterId = twitterId;
	}

	@Override
	public ISourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	@Override
	public ITweet getInReplyToTweetTwitter() {
		return inReplyToTweetTwitter;
	}

	public void setInReplyToTweetTwitter(Tweet inReplyToTweetTwitter) {
		this.inReplyToTweetTwitter = inReplyToTweetTwitter;
	}

	@Override
	public IUser getInReplyToUserTwitter() {
		return inReplyToUserTwitter;
	}

	public void setInReplyToUserTwitter(User inReplyToUserTwitter) {
		this.inReplyToUserTwitter = inReplyToUserTwitter;
	}

	@Override
	public long getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public IPlace getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public IUser getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getTweetDao();
	}
	
	@Override
	public void save() {
		sourceType.save();
		geo.save();
		place.save();
		user.save();
		this.sourceType.setId(sourceType.getId());
		this.geo.setId(geo.getId());
		this.place.setId(place.getId());
		this.user.setId(user.getId());
		super.save();
	}	
}
