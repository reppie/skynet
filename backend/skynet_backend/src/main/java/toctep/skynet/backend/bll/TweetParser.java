package toctep.skynet.backend.bll;

import toctep.skynet.backend.dal.dao.Dao;
import toctep.skynet.backend.dal.dao.DaoFacade;
import toctep.skynet.backend.dal.dao.impl.jdbc.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.*;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

public class TweetParser {
	
	private static TweetParser instance;
	
	private DaoFacade daoFacade;
	private Dao tweetDao;
	
	private TweetParser() {
		daoFacade = new DaoFacadeImpl();
		tweetDao = daoFacade.getTweetDao();
	}
	
	public static TweetParser getInstance() {
		if (instance == null) {
			instance = new TweetParser();
		}
		return instance;
	}
	
	public boolean parse(Status status) {
		System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
        System.out.println();        

        BoundingBoxType bbt = new BoundingBoxType();
        bbt.setText(status.getPlace().getBoundingBoxType());
        
        BoundingBox bb = new BoundingBox();
        String coordinates = "";
        GeoLocation[][] array = status.getPlace().getBoundingBoxCoordinates();
        for(GeoLocation[] x : array) {
        	for(GeoLocation y : x) {
        		coordinates += y.getLatitude() + ", " + y.getLongitude() + "; ";
        	}
        }        
        bb.setCoordinates(coordinates);
        bb.setType(bbt);
        
        Country country = new Country();
        country.setCode(status.getPlace().getCountryCode());
        country.setText(status.getPlace().getCountry());
        
        GeoType geoType = new GeoType();
        geoType.setText(status.getPlace().getGeometryType());
        
        Geo geo = new Geo();
        String geoCoordinates = "";
        GeoLocation[][] geoArray = status.getPlace().getBoundingBoxCoordinates();
        for(GeoLocation[] x : geoArray) {
        	for(GeoLocation y : x) {
        		geoCoordinates += y.getLatitude() + ", " + y.getLongitude() + "; ";
        	}
        }        
        geo.setCoordinates(geoCoordinates);
        geo.setType(geoType);
        
        Language language = new Language();
        language.setText(status.getUser().getLang()); 
        
        PlaceType placeType = new PlaceType();
        placeType.setText(status.getPlace().getPlaceType());
        
        SourceType sourceType = new SourceType();
        sourceType.setSourceType(status.getSource());
        
        TimeZone timeZone = new TimeZone();
        timeZone.setTimeZone(status.getUser().getTimeZone());
        timeZone.setUtcOffset(status.getUser().getUtcOffset());                
        
        Place place = new Place();
        twitter4j.Place placeStatus = status.getPlace();
        place.setTwitterId(placeStatus.getId());
        place.setName(placeStatus.getName());
        place.setFullName(placeStatus.getFullName());
        place.setStreetAddress(placeStatus.getStreetAddress());
        place.setLocality(""); //Twitter4j has no support for this?
        place.setRegion(""); //Twitter4j has no support for this?
        place.setIso3(""); //Twitter4j has no support for this?
        place.setPostalCode(""); //Twitter4j has no support for this?
        place.setPhone(""); //Twitter4j has no support for this?
        place.setTwitter(""); //Twitter4j has no support for this?
        place.setUrl(placeStatus.getURL());
        place.setAppId(""); //Twitter4j has no support for this?
        place.setType(placeType);
        place.setBoundingBox(bb);
        place.setCountry(country);
        
        Tweet tweet = new Tweet();
        tweet.setText(status.getText());
        tweet.setTruncated(status.isTruncated());
        tweet.setTwitterId(status.getId());
        tweet.setFavorited(status.isFavorited());
        tweet.setInReplyToTweetTwitterId(status.getInReplyToStatusId());
        tweet.setInReplyToUserTwitterId(status.getInReplyToUserId());
        tweet.setRetweetCount(status.getRetweetCount());
        tweet.setCreatedAt(status.getCreatedAt());
        tweet.setSourceType(sourceType);
        
        for(HashtagEntity hashtagEntity : status.getHashtagEntities()) {
            Hashtag hashtag = new Hashtag();
            hashtag.setText(hashtagEntity.getText());
            TweetHashtag tweetHashtag = new TweetHashtag();
            tweetHashtag.setHashtag(hashtag);
            tweetHashtag.setTweet(tweet);
        }        
        
        User user = new User();
        twitter4j.User userStatus = status.getUser();
        user.setTwitterId(userStatus.getId());
        user.setDefaultProfile(false); //Twitter4j has no support for this?
        user.setStatusesCount(userStatus.getStatusesCount());    
        user.setProfileBackgroundTile(0); //Twitter4j has no support for this?
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
        user.setCreatedAt(userStatus.getCreatedAt());
        user.setDefaultProfileImage(false); //Twitter4j has no support for this?
        user.setFollowersCount(userStatus.getFollowersCount()); //Same as setFollowing?
        user.setGeoEnabled(userStatus.isGeoEnabled());
        user.setProfileBackgroundImageUrl(userStatus.getProfileBackgroundImageUrl());
        user.setProfileBackgroundImageUrlHttps(userStatus.getProfileBackgroundImageUrlHttps());
        user.setFollowRequestSent(userStatus.isFollowRequestSent());
        user.setNotifications(0); //Twitter4j has no support for this?
        user.setProfileUseBackgroundImage(userStatus.isProfileUseBackgroundImage());
        user.setFriendsCount(userStatus.getFriendsCount());
        user.setProfileSideBarFillColor(userStatus.getProfileSidebarFillColor());
        user.setScreenName(userStatus.getScreenName());
        user.setProfileImageUrl(userStatus.getProfileImageURL().toExternalForm());
        user.setShowAllInlineMedia(userStatus.isShowAllInlineMedia());
        user.setTranslator(userStatus.isTranslator());
        user.setListedCount(userStatus.getListedCount());   
        user.setLanguage(language);
        user.setTimeZone(timeZone);
		
        for(long contributor : status.getContributors()) {
            TweetContributor tweetContributor = new TweetContributor();
            tweetContributor.setTweet(tweet);
            tweetContributor.setUser_twitter_id(contributor);
        } 
        
        for(UserMentionEntity mentionEntity : status.getUserMentionEntities()) {
            TweetMention tweetMention = new TweetMention();
            tweetMention.setTweet(tweet);
            tweetMention.setUser(mentionEntity.getId());
        } 
        
        for(URLEntity urlEntity : status.getURLEntities()) {
            URL url = new URL();
            url.setText(urlEntity.getDisplayURL());
            TweetURL tweetURL = new TweetURL();
            tweetURL.setTweet(tweet);
            tweetURL.setUrl(url);
        }       
		return true;
	}	
}
