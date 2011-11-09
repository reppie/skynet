package toctep.skynet.backend.dal.domain.tweet;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.hashtag.IHashtag;
import toctep.skynet.backend.dal.domain.keyword.IKeyword;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.sourcetype.ISourceType;
import toctep.skynet.backend.dal.domain.sourcetype.NullSourceType;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;
import toctep.skynet.backend.dal.domain.user.User;

public class Tweet extends Domain<Long> implements ITweet {

	private String text 					= "";
	private IGeo geo 						= NullGeo.getInstance();
	private boolean truncated 				= false;
	private long twitterId					= 0L;
	private ISourceType sourceType 			= NullSourceType.getInstance();
	private boolean favorited				= false;
	private ITweet inReplyToTweetTwitter 	= NullTweet.getInstance();
	private IUser inReplyToUserTwitter 		= NullUser.getInstance();
	private long retweetCount				= 0L;
	private Timestamp createdAt				= new Timestamp(0);
	private IPlace place 					= NullPlace.getInstance();
	private IUser user 						= NullUser.getInstance();
	private String coordinates				= "";
	
	private List<User> tweetContributors 	= new ArrayList<User>();
	private List<Hashtag> tweetHashtags 	= new ArrayList<Hashtag>();
	private List<Keyword> tweetKeywords 	= new ArrayList<Keyword>();
	private List<User> tweetMentions 		= new ArrayList<User>();
	private List<Url> tweetUrls 			= new ArrayList<Url>();
	
	public Tweet() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetDao());
	}
	
	public void addContributor(IUser contributor) {
		if (contributor instanceof User) {
			tweetContributors.add((User) contributor);
		}
	}
	
	public void addHashtag(IHashtag hashtag) {
		if (hashtag instanceof Hashtag) {
			tweetHashtags.add((Hashtag) hashtag);
		}
	}
	
	public void addKeyword(IKeyword keyword) {
		if (keyword instanceof Keyword) {
			tweetKeywords.add((Keyword) keyword);
		}
	}
	
	public void addMention(IUser mention) {
		if (mention instanceof User) {
			tweetMentions.add((User) mention);
		}
	}
	
	public void addUrl(IUrl url) {
		if (url instanceof Url) {
			tweetUrls.add((Url) url);
		}
	}
	
	public List<User> getContributors() {
		return tweetContributors;
	}
	
	public List<Hashtag> getHashtags() {
		return tweetHashtags;
	}
	
	public List<Keyword> getKeywords() {
		return tweetKeywords;
	}
	
	public List<User> getMentions() {
		return tweetMentions;
	}
	
	public List<Url> getUrls() {
		return tweetUrls;
	}
	
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
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

	private void saveContributors() {
		for(User contributor : tweetContributors) {
			TweetContributor tweetContributor = new TweetContributor();
			
			IUser existingUser = User.select(contributor.getScreenName());
			if (existingUser instanceof User) {
				tweetContributor.setUser(existingUser);
			} else {
				tweetContributor.setUser(contributor);
			}
			
			tweetContributor.setTweet(this);
			tweetContributor.save();
		}
	}
	
	private void saveHashtags() {
		for(Hashtag hashtag : tweetHashtags) {
			TweetHashtag tweetHashtag = new TweetHashtag();
			
			IHashtag existingHashtag = Hashtag.select(hashtag.getText());
			if (existingHashtag instanceof Hashtag) {
				tweetHashtag.setHashtag(existingHashtag);
			} else {
				tweetHashtag.setHashtag(hashtag);
			}
			
			tweetHashtag.setTweet(this);
			tweetHashtag.save();
		}
	}

	private void saveMentions() {
		for(User mention : tweetMentions) {
			TweetMention tweetMention = new TweetMention();
			
			IUser existingUser = User.select(mention.getScreenName());
			if (existingUser instanceof User) {
				tweetMention.setUser(existingUser);
			} else {
				tweetMention.setUser(mention);
			}
			
			tweetMention.setTweet(this);
			tweetMention.save();
		}
		
	}	
	
	private void saveUrls() {
		for(Url url : tweetUrls) {
			TweetUrl tweetUrl = new TweetUrl();
			
			IUrl existingUrl = Url.select(url.getId());
			if (existingUrl instanceof Url) {
				tweetUrl.setUrl(existingUrl);
			} else {
				tweetUrl.setUrl(url);
			}
			
			tweetUrl.setTweet(this);
			tweetUrl.save();
		}
	}

	private void saveKeywords() {
		for(Keyword keyword : tweetKeywords) {
			TweetKeyword tweetKeyword = new TweetKeyword();
			
			IKeyword existingKeyword = Keyword.select(keyword.getKeyword());
			if (existingKeyword instanceof Keyword) {
				tweetKeyword.setKeyword(existingKeyword);
			} else {
				tweetKeyword.setKeyword(keyword);
			}
			
			tweetKeyword.setTweetKeywordValue(keyword.getKeyword());
			tweetKeyword.setTweet(this);
			tweetKeyword.save();
		}
	}
	
	@Override
	public void save() {
		inReplyToTweetTwitter.save();
		inReplyToUserTwitter.save();
		sourceType.save();
		geo.save();
		place.save();
		user.save();
		
		if (isDirty()) {
			super.save();
		}
		
		saveContributors();
		saveHashtags();
		saveKeywords();
		saveMentions();
		saveUrls();
	}

	public static ITweet select(Long id) {
		TweetDao dao = DaoFacadeImpl.getInstance().getTweetDao();
		
		if (dao.exists(id)) {
			return (Tweet) dao.select(id);
		}
		
		return NullTweet.getInstance();
	}
	
	public static boolean exists(Long id) {
		TweetDao dao = DaoFacadeImpl.getInstance().getTweetDao();
		
		if(dao.exists(id)) {
			return true;
		}
		
		return false;
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getTweetDao().count();
	}
	
	public static boolean exists(Tweet tweet) {
		return DaoFacadeImpl.getInstance().getTweetDao().exists(tweet);
	}
	
}
