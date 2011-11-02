package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Date;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;
import toctep.skynet.backend.dal.domain.user.User;

public class Tweet extends Domain<Long> implements ITweet {

	private String text 					= "";
	private IGeo geo 						= new NullGeo();
	private boolean truncated 				= false;
	private long twitterId					= 0L;
	private ISourceType sourceType 			= new NullSourceType();
	private boolean favorited				= false;
	private ITweet inReplyToTweetTwitter 	= new NullTweet();
	private IUser inReplyToUserTwitter 		= new NullUser();
	private long retweetCount				= 0L;
	private Date createdAt					= new Date(0);
	private IPlace place 					= new NullPlace();
	private IUser user 						= new NullUser();
	private String coordinates				= "";
	
	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public IGeo getGeo() {
		return geo;
	}

	public void setGeo(IGeo geo) {
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

	public void setSourceType(ISourceType sourceType) {
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

	public void setInReplyToTweetTwitter(ITweet inReplyToTweetTwitter) {
		this.inReplyToTweetTwitter = inReplyToTweetTwitter;
	}

	@Override
	public IUser getInReplyToUserTwitter() {
		return inReplyToUserTwitter;
	}

	public void setInReplyToUserTwitter(IUser inReplyToUserTwitter) {
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

	public void setPlace(IPlace place) {
		this.place = place;
	}

	@Override
	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
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
		dao = DaoFacadeImpl.getInstance().getTweetDao();
	}
	
	@Override
	public void save() {
		
		if (inReplyToTweetTwitter instanceof Tweet) {
			((Tweet) inReplyToTweetTwitter).save();
			((Tweet) this.inReplyToTweetTwitter).setId(((Tweet) inReplyToTweetTwitter).getId());
		}
		
		if (inReplyToUserTwitter instanceof User) {
			((User) inReplyToUserTwitter).save();
			((User) this.inReplyToUserTwitter).setId(((User) inReplyToUserTwitter).getId());
		}	
		
		if (sourceType instanceof SourceType) {
			((SourceType) sourceType).save();
			((SourceType) this.sourceType).setId(((SourceType) sourceType).getId());
		}
		
		if (geo instanceof Geo) {
			((Geo) geo).save();
			((Geo) this.geo).setId(((Geo) geo).getId());
		}
		
		if (place instanceof Place) {
			((Place) place).save();
			((Place) this.place).setId(((Place) place).getId());
		}
		
		if (user instanceof User) {
			((User) user).save();
			((User) this.user).setId(((User) user).getId());
		}
		
		super.save();
	}
	
	public static ITweet select(Long id) {
		TweetDao dao = DaoFacadeImpl.getInstance().getTweetDao();
		
		if (dao.exists(id)) {
			return (Tweet) dao.select(id);
		}
		
		return new NullTweet();
	}
	
}
