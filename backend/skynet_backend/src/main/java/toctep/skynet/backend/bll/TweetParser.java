package toctep.skynet.backend.bll;

import java.text.ParseException;
import java.util.List;

import toctep.skynet.backend.Skynet;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.sourcetype.SourceType;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.dal.domain.tweet.NullTweet;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.dal.domain.user.NullUser;
import toctep.skynet.backend.dal.domain.user.User;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

public final class TweetParser {
	
	private static TweetParser instance;
	
	private TweetParser() { }
	
	public static TweetParser getInstance() {
		if (instance == null) {
			instance = new TweetParser();
		}
		return instance;
	}
	
	public Tweet parse(Status status) {
			Tweet tweet = new Tweet();
			
		try {
			BoundingBoxType boundingBoxType = parseBoundingBoxType(status.getPlace());
			BoundingBox boundingBox = parseBoundingBox(boundingBoxType, status.getPlace());
			Country country = parseCountry(status.getPlace());
			GeoType geoType = parseGeoType(status.getPlace());
			Geo geo = parseGeo(geoType, status.getPlace());
			Language language = parseLanguage(status.getUser());
			PlaceType placeType = parsePlaceType(status.getPlace());
			SourceType sourceType = parseSourceType(status);
			TimeZone timeZone = parseTimeZone(status.getUser());
			Place place = parsePlace(placeType, boundingBox, country, status.getPlace());
			User user = parseUser(place, language, timeZone, status.getUser());
			tweet = parseTweet(user, geo, sourceType, place, status);
			
			parseUrl(tweet, status);
			parseHashtag(tweet, status);
			parseContributor(tweet, status);
			parseMention(tweet, status);
			parseKeyword(tweet);
			
		} catch (ParseException e) {
			Skynet.LOG.error(e.getMessage(), e);
		}
		tweet.save();
		return tweet;
	}
	
	private BoundingBoxType parseBoundingBoxType(twitter4j.Place place) {
        BoundingBoxType boundingBoxType = new BoundingBoxType();
        boundingBoxType.setText(place.getBoundingBoxType());
        return boundingBoxType;
	}
	
	private BoundingBox parseBoundingBox(BoundingBoxType type, twitter4j.Place place) {
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

    private Geo parseGeo(GeoType type, twitter4j.Place place) {
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
    
    private PlaceType parsePlaceType(twitter4j.Place place) {
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
    
    private Place parsePlace(PlaceType type, BoundingBox boundingBox, Country country, twitter4j.Place placeStatus) {
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
    
    private User parseUser(Place place, Language language, TimeZone timeZone, twitter4j.User userStatus) throws ParseException {
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

	private Tweet parseTweet(User user, Geo geo, SourceType sourceType, Place place, Status status) {
        Tweet tweet = new Tweet();
        tweet.setId(status.getId());
        tweet.setText(status.getText());
        tweet.setTruncated(status.isTruncated());
        tweet.setFavorited(status.isFavorited());
        
        if(Tweet.exists(status.getInReplyToStatusId())) {
            tweet.setInReplyToTweetTwitter((Tweet.select(status.getInReplyToStatusId())));
        }
        else if (status.getInReplyToStatusId() == -1) {
        	tweet.setInReplyToTweetTwitter(NullTweet.getInstance());
        }
        else {
        	try {
				twitter4j.Status replyTweet = TwitterFactory.getSingleton().showStatus(status.getInReplyToStatusId());
				tweet.setInReplyToTweetTwitter(parse(replyTweet));
			} catch (TwitterException e) {
				e.printStackTrace();
			}
        }
        
        if(User.exists(status.getInReplyToUserId())) {
            tweet.setInReplyToUserTwitter(User.select(status.getInReplyToUserId()));
        }
        else if (status.getInReplyToUserId() == -1) {
        	tweet.setInReplyToUserTwitter(NullUser.getInstance());
        }
        else {
        	try {
				twitter4j.User replyUser = TwitterFactory.getSingleton().showUser(status.getInReplyToUserId());
				tweet.setInReplyToUserTwitter(parse(replyUser.getStatus()).getUser());
			} catch (TwitterException e) {
				e.printStackTrace();
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
