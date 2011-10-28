package toctep.skynet.backend.test;

import java.util.Date;

import toctep.skynet.backend.dal.domain.Language;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.TimeZone;
import toctep.skynet.backend.dal.domain.URL;
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
		
		URL url = new URL();
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
		
		String name = "Test";
		preUser.setName(name);
		
		userDao.insert(preUser);
		assertEquals(1, userDao.count());
		
		User postUser = (User) userDao.select(preUser.getId());
		assertTrue(postUser.getName().equals(preUser.getName()));
		// TODO
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
