package toctep.skynet.backend.bll;

import java.text.ParseException;
import java.util.List;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBoxType;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;
import toctep.skynet.backend.dal.domain.geo.IGeo;
import toctep.skynet.backend.dal.domain.geo.IGeoType;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.geo.NullGeoType;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.IPlaceType;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.place.NullPlaceType;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.sourcetype.SourceType;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.dal.domain.tweet.NullTweet;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;
import toctep.skynet.backend.dal.domain.user.User;
import toctep.skynet.backend.log.Log;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

public final class TweetParser {
	
	private static TweetParser instance;
	
	private TweetParser() {}
	
	public static TweetParser getInstance() {
		if (instance == null) {
			instance = new TweetParser();
		}
		return instance;
	}
	
	public Tweet parse(Status status) {
		Tweet tweet = new Tweet();
		IBoundingBoxType boundingBoxType = NullBoundingBoxType.getInstance();
		IBoundingBox boundingBox = NullBoundingBox.getInstance();
		ICountry country = NullCountry.getInstance();
		IGeoType geoType = NullGeoType.getInstance();
		IGeo geo = NullGeo.getInstance();
		IPlaceType placeType = NullPlaceType.getInstance();
		IPlace place = NullPlace.getInstance();
		try {
			if(status.getPlace() != null) {
				boundingBoxType = parseBoundingBoxType(status.getPlace());
				boundingBox = parseBoundingBox(boundingBoxType, status.getPlace());
				country = parseCountry(status.getPlace());
				geoType = parseGeoType(status.getPlace());
				geo = parseGeo(geoType, status.getPlace());
				placeType = parsePlaceType(status.getPlace());
				place = parsePlace(placeType, boundingBox, country, status.getPlace());
			}
			Language language = parseLanguage(status.getUser());
			SourceType sourceType = parseSourceType(status);
			TimeZone timeZone = parseTimeZone(status.getUser());
			IUser user = parseUser(place, language, timeZone, status.getUser());
			tweet = parseTweet(user, geo, sourceType, place, status);
			
			parseUrl(tweet, status);
			parseHashtag(tweet, status);
			parseContributor(tweet, status);
			parseMention(tweet, status);
			parseKeyword(tweet);
		} catch (ParseException e) {
			Log.error(e.getMessage(), e);
		}
		return tweet;
	}
	
	private BoundingBoxType parseBoundingBoxType(twitter4j.Place place) {
        BoundingBoxType boundingBoxType = new BoundingBoxType();
        boundingBoxType.setText(place.getBoundingBoxType());
        return boundingBoxType;
	}
	
	private BoundingBox parseBoundingBox(IBoundingBoxType type, twitter4j.Place place) {
        BoundingBox boundingBox = new BoundingBox();
        String coordinates = "";
        GeoLocation[][] array = place.getBoundingBoxCoordinates();
        for(GeoLocation[] x : array) {
        	for(GeoLocation y : x) {
        		coordinates += y.getLatitude() + ", " + y.getLongitude() + "; ";
        	}
        }
        boundingBox.setCoordinates(coordinates);
        boundingBox.setType(type);
        return boundingBox;
	}

    private Country parseCountry(twitter4j.Place place) {
        Country country = new Country();
        country.setId(place.getCountryCode());
        country.setText(place.getCountry());
        return country;
    }

    private GeoType parseGeoType(twitter4j.Place place) {        
    	GeoType geoType = new GeoType();
        geoType.setText(place.getGeometryType());
        return geoType;
    }

    private Geo parseGeo(IGeoType type, twitter4j.Place place) {
    	Geo geo = new Geo();
        String geoCoordinates = "";
        GeoLocation[][] geoArray = place.getBoundingBoxCoordinates();
        for(GeoLocation[] x : geoArray) {
        	for(GeoLocation y : x) {
        		geoCoordinates += y.getLatitude() + ", " + y.getLongitude() + "; ";
        	}
        }        
        geo.setCoordinates(geoCoordinates);
        geo.setType(type);   
        return geo;
    }

    private Language parseLanguage(twitter4j.User user) {
        Language language = new Language();
        language.setText(user.getLang());
        return language;
    }
    
    private IPlaceType parsePlaceType(twitter4j.Place place) {
        PlaceType placeType = new PlaceType();
        placeType.setText(place.getPlaceType());
        return placeType;
    }
    
    private SourceType parseSourceType(Status status) {
    	SourceType sourceType = new SourceType();
        sourceType.setText(status.getSource());
        return sourceType;
    }
    
    private TimeZone parseTimeZone(twitter4j.User user) {
        TimeZone timeZone = new TimeZone();
        timeZone.setTimeZone(user.getTimeZone());
        timeZone.setUtcOffset(user.getUtcOffset());
        return timeZone;
    }
    
    private Place parsePlace(IPlaceType type, IBoundingBox boundingBox, ICountry country, twitter4j.Place placeStatus) {
        Place place = new Place();
        place.setId(placeStatus.getId());
        place.setName(placeStatus.getName());
        place.setFullName(placeStatus.getFullName());
        place.setStreetAddress(placeStatus.getStreetAddress());
        place.setLocality(""); //Twitter4j has no support for this?
        place.setRegion(""); //Twitter4j has no support for this?
        place.setIso3(""); //Twitter4j has no support for this?
        place.setPostalCode(""); //Twitter4j has no support for this?
        place.setPhone(""); //Twitter4j has no support for this?
        place.setTwitter(""); //Twitter4j has no support for this?
        if(placeStatus.getURL() != null) {
        	Url placeUrl = new Url();
        	placeUrl.setId(placeStatus.getURL());
        	place.setUrl(placeUrl);
        }
        place.setAppId(""); //Twitter4j has no support for this?
        place.setType(type);
        place.setBoundingBox(boundingBox);
        place.setCountry(country);
        return place;
    }
    
    private IUser parseUser(IPlace place, ILanguage language, ITimeZone timeZone, twitter4j.User userStatus) throws ParseException {
        User user = new User();
        user.setId(userStatus.getId());
        user.setDefaultProfile(false); //Twitter4j has no support for this?
        user.setStatusesCount(userStatus.getStatusesCount());    
        user.setProfileBackgroundTiled(userStatus.isProfileBackgroundTiled());
        user.setProfileLinkColor(userStatus.getProfileLinkColor());
        user.setFollowing(userStatus.getFollowersCount());
        user.setFavouritesCount(userStatus.getFavouritesCount());
        user.setProtected(userStatus.isProtected());
        user.setProfileTextColor(userStatus.getProfileTextColor());
        user.setVerified(userStatus.isVerified());
        user.setContributorsEnabled(userStatus.isContributorsEnabled());
        user.setDescription(user.getDescription());
        user.setName(userStatus.getName());
        user.setProfileSidebarBorderColor(userStatus.getProfileSidebarBorderColor());
        user.setProfileBackgroundColor(userStatus.getProfileBackgroundColor());
        user.setCreatedAt(TweetUtils.createUTCTimeStamp(userStatus.getCreatedAt()));
        user.setDefaultProfileImage(false); //Twitter4j has no support for this?
        user.setFollowersCount(userStatus.getFollowersCount()); //Same as setFollowing?
        user.setGeoEnabled(userStatus.isGeoEnabled());
        user.setFollowRequestSent(userStatus.isFollowRequestSent());
        user.setNotifications(0); //Twitter4j has no support for this?
        user.setProfileUseBackgroundImage(userStatus.isProfileUseBackgroundImage());
        user.setFriendsCount(userStatus.getFriendsCount());
        user.setProfileSideBarFillColor(userStatus.getProfileSidebarFillColor());
        user.setScreenName(userStatus.getScreenName());
        user.setShowAllInlineMedia(userStatus.isShowAllInlineMedia());
        user.setTranslator(userStatus.isTranslator());
        user.setListedCount(userStatus.getListedCount());   
        user.setPlace(place);
        user.setLanguage(language);
        user.setTimeZone(timeZone);
        user = parseUserUrls(user, userStatus);
        return user;
    }
    
    private User parseUserUrls(User user, twitter4j.User userStatus) {
        if(userStatus.getProfileBackgroundImageUrl() != null) {
            Url profileBgUrl = new Url();
        	profileBgUrl.setId(userStatus.getProfileBackgroundImageUrl());
            user.setProfileBackgroundImageUrl(profileBgUrl);
        }
        if(userStatus.getProfileBackgroundImageUrlHttps() != null) {
            Url profileBgUrlHttps = new Url();
        	profileBgUrlHttps.setId(userStatus.getProfileBackgroundImageUrlHttps());
            user.setProfileBackgroundImageUrlHttps(profileBgUrlHttps);
        }
        if(userStatus.getProfileImageURL().toExternalForm() != null) {
            Url profileImageUrl = new Url();
        	profileImageUrl.setId(userStatus.getProfileImageURL().toExternalForm());
            user.setProfileImageUrl(profileImageUrl);
        }
        if(userStatus.getProfileImageUrlHttps().toExternalForm() != null) {
            Url profileImageUrlHttps = new Url();
        	profileImageUrlHttps.setId(userStatus.getProfileImageUrlHttps().toExternalForm());
        	user.setProfileImageUrlHttps(profileImageUrlHttps);
        }
        if (userStatus.getURL() != null) {
            Url userUrl = new Url();
        	userUrl.setId(userStatus.getURL().toExternalForm());
            user.setUrl(userUrl);
        }       
        return user;
	}

	private Tweet parseTweet(IUser user, IGeo geo, SourceType sourceType, IPlace place, Status status) {
        Tweet tweet = new Tweet();
        tweet.setId(status.getId());
        tweet.setText(status.getText());
        tweet.setTruncated(status.isTruncated());
        tweet.setFavorited(status.isFavorited());
        
        if(Tweet.exists(status.getInReplyToStatusId())) {
            tweet.setInReplyToTweetTwitter((Tweet.select(status.getInReplyToStatusId())));
        } else {
        	tweet.setInReplyToTweetTwitter(NullTweet.getInstance());
        }
        
        if(User.exists(status.getInReplyToUserId())) {
            tweet.setInReplyToUserTwitter(User.select(status.getInReplyToUserId()));
        } else if (status.getInReplyToUserId() == -1) {
        	tweet.setInReplyToUserTwitter(NullUser.getInstance());
        } else {
        	try {
    			twitter4j.User replyUser = TwitterFactory.getSingleton().showUser(status.getInReplyToUserId());
    			tweet.setInReplyToUserTwitter(parseUser(NullPlace.getInstance(), NullLanguage.getInstance(), NullTimeZone.getInstance(), replyUser));
			} catch (TwitterException e) {
				Log.error(e.getMessage(), e);
			} catch (ParseException e) {
				Log.error(e.getMessage(), e);
			}
        }
        
        tweet.setRetweetCount(status.getRetweetCount());
        tweet.setCreatedAt(TweetUtils.createUTCTimeStamp(status.getCreatedAt()));
        tweet.setGeo(geo);
        tweet.setSourceType(sourceType);
        tweet.setPlace(place);
        tweet.setUser(user);
        
        return tweet;
    }
    
    private List<User> parseContributor(Tweet tweet, Status status) {
    	if (status.getContributors() != null) {
	        for(long contributor : status.getContributors()) {
	            User contributorUser  = new User();
	            contributorUser.setId(contributor);
	            tweet.addContributor(contributorUser);
	        }
    	}
    	return tweet.getContributors();
    }
    
    private List<Hashtag> parseHashtag(Tweet tweet, Status status) {
        for(HashtagEntity hashtagEntity : status.getHashtagEntities()) {
            Hashtag hashtag = new Hashtag();
            hashtag.setText(hashtagEntity.getText());
            tweet.addHashtag(hashtag);
        } 
        return tweet.getHashtags();
    }
    
    private List<Keyword> parseKeyword(Tweet tweet) {
        List<Keyword> keywords = new TweetIndexer().indexTweetKeywords(tweet);
        for(Keyword keyword : keywords) {
        	tweet.addKeyword(keyword);
        }
        return tweet.getKeywords();
    }
    
    private List<User> parseMention(Tweet tweet, Status status) {
        for(UserMentionEntity mentionEntity : status.getUserMentionEntities()) {
            User mentionedUser = new User();
            mentionedUser.setId(mentionEntity.getId());
            tweet.addMention(mentionedUser);
        }
        return tweet.getMentions();
    }
    
    private List<Url> parseUrl(Tweet tweet, Status status) {
        for(URLEntity urlEntity : status.getURLEntities()) {
            Url url = new Url();
            url.setId(urlEntity.getDisplayURL());
            tweet.addUrl(url);
        }
        return tweet.getUrls();
    }    
}
