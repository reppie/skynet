package toctep.skynet.backend.test;

import java.util.Date;

import toctep.skynet.backend.dal.domain.Language;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.TimeZone;
import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.User;

public class UserTest extends DomainTest {
	
	@Override
	public void testCreate() { 
		User user = new User();
		assertNotNull(user);
		
		long twitterId = 0L;
		user.setTwitterId(twitterId);
		assertEquals(twitterId, user.getTwitterId());
		
		Place place = new Place();
		user.setPlace(place);
		assertTrue(place.equals(user.getPlace()));
		
		boolean defaultProfile = false;
		user.setDefaultProfile(defaultProfile);
		assertTrue(user.isDefaultProfile() == defaultProfile);
		
		int statusesCount = 1;
		user.setStatusesCount(statusesCount);
		assertEquals(statusesCount, user.getStatusesCount());
		
		long profileBackgroundTile = 0L;
		user.setProfileBackgroundTile(profileBackgroundTile);
		assertEquals(profileBackgroundTile, user.getProfileBackgroundTile());
		
		Language language = new Language();
		user.setLanguage(language);
		assertEquals(language, user.getLanguage());
		
		String profileLinkColor = "test";
		user.setProfileLinkColor(profileLinkColor);
		assertTrue(profileLinkColor.equals(user.getProfileLinkColor()));
		
		int following = 0;
		user.setFollowing(following);
		assertEquals(following, user.getFollowing());
		
		int favouritesCount = 0;
		user.setFollowersCount(favouritesCount);
		assertEquals(favouritesCount, user.getFavouritesCount());
		
		boolean isProtected = false;
		user.setProtected(isProtected);
		assertTrue(isProtected == user.isProtected());
		
		String profileTextColor = "test";
		user.setProfileTextColor(profileTextColor);
		assertTrue(profileTextColor.equals(user.getProfileTextColor()));
		
		boolean verified = false;
		user.setVerified(verified);
		assertTrue(verified == user.isVerified());
		
		boolean contributorsEnabled = false;
		user.setContributorsEnabled(contributorsEnabled);
		assertTrue(contributorsEnabled == user.isContributorsEnabled());
		
		String description = "test";
		user.setDescription(description);
		assertTrue(description.equals(user.getDescription()));
		
		String name = "test";
		user.setName(name);
		assertTrue(name.equals(user.getName()));
		
		String profileSidebarBorderColor = "test";
		user.setProfileSidebarBorderColor(profileSidebarBorderColor);
		assertTrue(profileSidebarBorderColor.equals(user.getProfileSidebarBorderColor()));
		
		String profileBackgroundColor = "test";
		user.setProfileBackgroundColor(profileBackgroundColor);
		assertTrue(profileBackgroundColor.equals(user.getProfileBackgroundColor()));
	
		Date createdAt = new Date();
		user.setCreatedAt(createdAt);
		assertTrue(createdAt.equals(user.getCreatedAt()));
		
		boolean defaultProfileImage = false;
		user.setDefaultProfileImage(defaultProfileImage);
		assertTrue(defaultProfileImage == user.isDefaultProfileImage());
		
		int followersCount = 0;
		user.setFollowersCount(followersCount);
		assertEquals(followersCount, user.getFollowersCount());
		
		boolean geoEnabled = false;
		user.setGeoEnabled(geoEnabled);
		assertTrue(geoEnabled == user.isGeoEnabled());
		
		String profileBackgroundImageUrl = "test";
		user.setProfileBackgroundImageUrl(profileBackgroundImageUrl);
		assertTrue(profileBackgroundImageUrl.equals(user.getProfileBackgroundImageUrl()));
		
		String profileBackgroundImageUrlHttps = "test";
		user.setProfileBackgroundImageUrlHttps(profileBackgroundImageUrlHttps);
		assertTrue(profileBackgroundImageUrlHttps.equals(user.getProfileBackgroundImageUrlHttps()));
	
		boolean followRequestSent = false;
		user.setFollowRequestSent(followRequestSent);
		assertTrue(followRequestSent == user.isFollowRequestSent());
		
		Url url = new Url();
		user.setUrl(url);
		assertTrue(url.equals(user.getUrl()));
		
		TimeZone timeZone = new TimeZone();
		user.setTimeZone(timeZone);
		assertTrue(timeZone.equals(user.getTimeZone()));
		
		long notifications = 0L;
		user.setNotifications(notifications);
		assertEquals(notifications, user.getNotifications());
		
		boolean profileUseBackgroundImage = false;
		user.setProfileUseBackgroundImage(profileUseBackgroundImage);
		assertTrue(profileUseBackgroundImage == user.isProfileUseBackgroundImage());
		
		int friendsCount = 0;
		user.setFriendsCount(friendsCount);
		assertEquals(friendsCount, user.getFriendsCount());
		
		String profileSideBarFillColor = "test";
		user.setProfileSideBarFillColor(profileSideBarFillColor);
		assertTrue(profileSideBarFillColor.equals(user.getProfileSideBarFillColor()));
		
		String screenName = "test";
		user.setScreenName(screenName);
		assertTrue(screenName.equals(user.getScreenName()));
		
		String profileImageUrl = "test";
		user.setProfileImageUrl(profileImageUrl);
		assertTrue(profileImageUrl.equals(user.getProfileImageUrl()));
		
		boolean showAllInlineMedia = false;
		user.setShowAllInlineMedia(showAllInlineMedia);
		assertTrue(showAllInlineMedia == user.isShowAllInlineMedia());
		
		boolean isTranslator = false;
		user.setTranslator(isTranslator);
		assertTrue(isTranslator == user.isTranslator());
		
		int listedCount = 0;
		user.setListedCount(listedCount);
		assertEquals(listedCount, user.getListedCount());
	}
	
	@Override
	public void testInsert() {
		User preUser = new User();
		
		long twitterId = 0L;
		preUser.setTwitterId(twitterId);
		
		Place place = new Place();
		preUser.setPlace(place);
		
		boolean defaultProfile = false;
		preUser.setDefaultProfile(defaultProfile);
		
		int statusesCount = 1;
		preUser.setStatusesCount(statusesCount);
		
		long profileBackgroundTile = 0L;
		preUser.setProfileBackgroundTile(profileBackgroundTile);
		
		Language language = new Language();
		preUser.setLanguage(language);
		
		String profileLinkColor = "test";
		preUser.setProfileLinkColor(profileLinkColor);
		
		int following = 0;
		preUser.setFollowing(following);
		
		int favouritesCount = 0;
		preUser.setFollowersCount(favouritesCount);
		
		boolean isProtected = false;
		preUser.setProtected(isProtected);
		
		String profileTextColor = "test";
		preUser.setProfileTextColor(profileTextColor);
		
		boolean verified = false;
		preUser.setVerified(verified);
		
		boolean contributorsEnabled = false;
		preUser.setContributorsEnabled(contributorsEnabled);
		
		String description = "test";
		preUser.setDescription(description);
		
		String name = "test";
		preUser.setName(name);
		
		String profileSidebarBorderColor = "test";
		preUser.setProfileSidebarBorderColor(profileSidebarBorderColor);
		
		String profileBackgroundColor = "test";
		preUser.setProfileBackgroundColor(profileBackgroundColor);
	
		Date createdAt = new Date();
		preUser.setCreatedAt(createdAt);
		
		boolean defaultProfileImage = false;
		preUser.setDefaultProfileImage(defaultProfileImage);
		
		int followersCount = 0;
		preUser.setFollowersCount(followersCount);
		
		boolean geoEnabled = false;
		preUser.setGeoEnabled(geoEnabled);
		
		String profileBackgroundImageUrl = "test";
		preUser.setProfileBackgroundImageUrl(profileBackgroundImageUrl);
		
		String profileBackgroundImageUrlHttps = "test";
		preUser.setProfileBackgroundImageUrlHttps(profileBackgroundImageUrlHttps);
	
		boolean followRequestSent = false;
		preUser.setFollowRequestSent(followRequestSent);
		
		URL url = new URL();
		preUser.setUrl(url);
		
		TimeZone timeZone = new TimeZone();
		preUser.setTimeZone(timeZone);
		
		long notifications = 0L;
		preUser.setNotifications(notifications);
		
		boolean profileUseBackgroundImage = false;
		preUser.setProfileUseBackgroundImage(profileUseBackgroundImage);
		
		int friendsCount = 0;
		preUser.setFriendsCount(friendsCount);
		
		String profileSideBarFillColor = "test";
		preUser.setProfileSideBarFillColor(profileSideBarFillColor);
		
		String screenName = "test";
		preUser.setScreenName(screenName);
		
		String profileImageUrl = "test";
		preUser.setProfileImageUrl(profileImageUrl);
		
		boolean showAllInlineMedia = false;
		preUser.setShowAllInlineMedia(showAllInlineMedia);
		
		boolean isTranslator = false;
		preUser.setTranslator(isTranslator);
		
		int listedCount = 0;
		preUser.setListedCount(listedCount);
		
		userDao.insert(preUser);
		assertEquals(1, userDao.count());
		
		User postUser = (User) userDao.select(preUser.getId());
		assertEquals(postUser.getTwitterId(), preUser.getTwitterId());
		assertTrue(postUser.getPlace().equals(preUser.getPlace()));
		assertTrue(postUser.isDefaultProfile() == preUser.isDefaultProfile());
		assertEquals(postUser.getStatusesCount(), preUser.getStatusesCount());
		assertEquals(postUser.getProfileBackgroundTile(), preUser.getProfileBackgroundTile());
		assertTrue(postUser.getLanguage().equals(preUser.getLanguage()));
		assertEquals(postUser.getProfileLinkColor(), preUser.getProfileLinkColor());
		assertEquals(postUser.getFollowing(), preUser.getFollowing());
		assertEquals(postUser.getFavouritesCount(), preUser.getFavouritesCount());
		assertTrue(postUser.isProtected() == preUser.isProtected());
		assertEquals(postUser.getProfileTextColor(), preUser.getProfileTextColor());
		assertTrue(postUser.isVerified() == preUser.isVerified());
		assertTrue(postUser.isContributorsEnabled() == preUser.isContributorsEnabled());
		assertEquals(postUser.getDescription(), preUser.getDescription());
		assertEquals(postUser.getName(), preUser.getName());
		assertEquals(postUser.getProfileSidebarBorderColor(), preUser.getProfileSidebarBorderColor());
		assertEquals(postUser.getProfileBackgroundColor(), preUser.getProfileBackgroundColor());
		assertTrue(postUser.getCreatedAt().equals(preUser.getCreatedAt()));
		assertTrue(postUser.isDefaultProfileImage() == preUser.isDefaultProfileImage());
		assertEquals(postUser.getFollowersCount(), preUser.getFollowersCount());
		assertTrue(postUser.isGeoEnabled() == preUser.isGeoEnabled());
		assertEquals(postUser.getProfileBackgroundImageUrl(), preUser.getProfileBackgroundImageUrl());
		assertEquals(postUser.getProfileBackgroundImageUrlHttps(), preUser.getProfileBackgroundImageUrlHttps());
		assertTrue(postUser.isFollowRequestSent() == preUser.isFollowRequestSent());
		assertTrue(postUser.getUrl().equals(preUser.getUrl()));
		assertTrue(postUser.getTimeZone().equals(preUser.getTimeZone()));
		assertEquals(postUser.getNotifications(), preUser.getNotifications());
		assertTrue(postUser.isProfileUseBackgroundImage() == preUser.isProfileUseBackgroundImage());
		assertEquals(postUser.getFriendsCount(), preUser.getFriendsCount());
		assertEquals(postUser.getProfileSideBarFillColor(), preUser.getProfileSideBarFillColor());
		assertEquals(postUser.getScreenName(), preUser.getScreenName());
		assertEquals(postUser.getProfileImageUrl(), preUser.getProfileImageUrl());
		assertTrue(postUser.isShowAllInlineMedia() == preUser.isShowAllInlineMedia());
		assertTrue(postUser.isTranslator() == preUser.isTranslator());
		assertEquals(postUser.getListedCount(), preUser.getListedCount());						
	}
	
	@Override
	public void testUpdate() {
		// TODO
	}
	
	@Override
	public void testDelete() {
		User user = new User();
		assertNotNull(user);
		userDao.insert(user);
		assertEquals(1, userDao.count());
		userDao.delete(user);
		assertEquals(0, userDao.count());
	}

}
