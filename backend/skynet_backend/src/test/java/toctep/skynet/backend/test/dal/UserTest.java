package toctep.skynet.backend.test.dal;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;
import toctep.skynet.backend.dal.domain.user.User;

public class UserTest extends DomainTest {
	
	private User user;
	
	private long id;
	private IPlace place;
	private boolean defaultProfile;
	private int statusesCount;
	private boolean profileBackgroundTiled;
	private ILanguage language;
	private String profileLinkColor;
	private int following;
	private int favouritesCount;
	private boolean isProtected;
	private String profileTextColor;
	private boolean verified;
	private boolean contributorsEnabled;
	private String description;
	private String name;
	private String profileSidebarBorderColor;
	private String profileBackgroundColor;
	private Timestamp createdAt;
	private boolean defaultProfileImage;
	private int followersCount;
	private boolean geoEnabled;
	private IUrl profileBackgroundImageUrl;
	private IUrl profileBackgroundImageUrlHttps;
	private boolean followRequestSent;
	private IUrl url;
	private ITimeZone timeZone;
	private int notifications;
	private boolean profileUseBackgroundImage;
	private int friendsCount;
	private String profileSideBarFillColor;
	private String screenName;
	private IUrl profileImageUrl;
	private IUrl profileImageUrlHttps;
	private boolean showAllInlineMedia;
	private boolean isTranslator;
	private int listedCount;
	
	@Override
	public void setUp() {
		super.setUp();
		
		user = new User();
		
		id = 0L;
		user.setId(id);
		
		place = NullPlace.getInstance();
		user.setPlace(place);
		
		defaultProfile = false;
		user.setDefaultProfile(defaultProfile);
		
		statusesCount = 1;
		user.setStatusesCount(statusesCount);
		
		profileBackgroundTiled = false;
		user.setProfileBackgroundTiled(profileBackgroundTiled);
		
		language = NullLanguage.getInstance();
		user.setLanguage(language);
		
		profileLinkColor = "test";
		user.setProfileLinkColor(profileLinkColor);
		
		following = 0;
		user.setFollowing(following);
		
		favouritesCount = 0;
		user.setFollowersCount(favouritesCount);
		
		isProtected = false;
		user.setProtected(isProtected);
		
		profileTextColor = "test";
		user.setProfileTextColor(profileTextColor);
		
		verified = false;
		user.setVerified(verified);
		
		contributorsEnabled = false;
		user.setContributorsEnabled(contributorsEnabled);
		
		description = "test";
		user.setDescription(description);
		
		name = "test";
		user.setName(name);
		
		profileSidebarBorderColor = "test";
		user.setProfileSidebarBorderColor(profileSidebarBorderColor);
		
		profileBackgroundColor = "test";
		user.setProfileBackgroundColor(profileBackgroundColor);
	
		createdAt = new Timestamp(0);
		user.setCreatedAt(createdAt);
		
		defaultProfileImage = false;
		user.setDefaultProfileImage(defaultProfileImage);
		
		followersCount = 0;
		user.setFollowersCount(followersCount);
		
		geoEnabled = false;
		user.setGeoEnabled(geoEnabled);
		
		profileBackgroundImageUrl = NullUrl.getInstance();
		user.setProfileBackgroundImageUrl(profileBackgroundImageUrl);
		
		profileBackgroundImageUrlHttps = NullUrl.getInstance();
		user.setProfileBackgroundImageUrlHttps(profileBackgroundImageUrlHttps);
	
		followRequestSent = false;
		user.setFollowRequestSent(followRequestSent);
		
		url = NullUrl.getInstance();
		user.setUrl(url);
		
		timeZone = NullTimeZone.getInstance();
		user.setTimeZone(timeZone);
		
		notifications = 0;
		user.setNotifications(notifications);
		
		profileUseBackgroundImage = false;
		user.setProfileUseBackgroundImage(profileUseBackgroundImage);
		
		friendsCount = 0;
		user.setFriendsCount(friendsCount);
		
		profileSideBarFillColor = "test";
		user.setProfileSideBarFillColor(profileSideBarFillColor);
		
		screenName = "test";
		user.setScreenName(screenName);
		
		profileImageUrl = NullUrl.getInstance();
		user.setProfileImageUrl(profileImageUrl);
		
		profileImageUrlHttps = NullUrl.getInstance();
		user.setProfileImageUrlHttps(profileImageUrlHttps);
		
		showAllInlineMedia = false;
		user.setShowAllInlineMedia(showAllInlineMedia);
		
		isTranslator = false;
		user.setTranslator(isTranslator);
		
		listedCount = 0;
		user.setListedCount(listedCount);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(user);
		assertTrue(new Long(id).equals(user.getId()));
		assertTrue(place.equals(user.getPlace()));
		assertTrue(user.isDefaultProfile() == defaultProfile);
		assertEquals(statusesCount, user.getStatusesCount());
		assertTrue(profileBackgroundTiled == user.isProfileBackgroundTiled());
		assertEquals(language, user.getLanguage());
		assertTrue(profileLinkColor.equals(user.getProfileLinkColor()));
		assertEquals(following, user.getFollowing());
		assertEquals(favouritesCount, user.getFavouritesCount());
		assertTrue(isProtected == user.isProtected());
		assertTrue(profileTextColor.equals(user.getProfileTextColor()));
		assertTrue(verified == user.isVerified());
		assertTrue(contributorsEnabled == user.isContributorsEnabled());
		assertTrue(description.equals(user.getDescription()));
		assertTrue(name.equals(user.getName()));
		assertTrue(profileSidebarBorderColor.equals(user.getProfileSidebarBorderColor()));
		assertTrue(profileBackgroundColor.equals(user.getProfileBackgroundColor()));
		assertTrue(createdAt.equals(user.getCreatedAt()));
		assertTrue(defaultProfileImage == user.isDefaultProfileImage());
		assertEquals(followersCount, user.getFollowersCount());
		assertTrue(geoEnabled == user.isGeoEnabled());
		assertTrue(profileBackgroundImageUrl.equals(user.getProfileBackgroundImageUrl()));
		assertTrue(profileBackgroundImageUrlHttps.equals(user.getProfileBackgroundImageUrlHttps()));
		assertTrue(followRequestSent == user.isFollowRequestSent());
		assertTrue(url.equals(user.getUrl()));
		assertTrue(timeZone.equals(user.getTimeZone()));
		assertEquals(notifications, user.getNotifications());
		assertTrue(profileUseBackgroundImage == user.isProfileUseBackgroundImage());
		assertEquals(friendsCount, user.getFriendsCount());
		assertTrue(profileSideBarFillColor.equals(user.getProfileSideBarFillColor()));
		assertTrue(screenName.equals(user.getScreenName()));
		assertTrue(profileImageUrl.equals(user.getProfileImageUrl()));
		assertTrue(profileImageUrlHttps.equals(user.getProfileImageUrlHttps()));
		assertTrue(showAllInlineMedia == user.isShowAllInlineMedia());
		assertTrue(isTranslator == user.isTranslator());
		assertEquals(listedCount, user.getListedCount());
	}
	
	@Override
	public void testInsert() {
		user.save();
		assertEquals(1, userDao.count());
	}
	
	@Override
	public void testSelect() {
		user.save();
		
		User postUser = (User) userDao.select(user.getId());
		
		assertEquals(postUser.getId(), user.getId());
		assertTrue(postUser.getPlace().equals(user.getPlace()));
		assertTrue(postUser.isDefaultProfile() == user.isDefaultProfile());
		assertEquals(postUser.getStatusesCount(), user.getStatusesCount());
		assertTrue(postUser.isProfileBackgroundTiled() == user.isProfileBackgroundTiled());
		assertTrue(postUser.getLanguage().equals(user.getLanguage()));
		assertEquals(postUser.getProfileLinkColor(), user.getProfileLinkColor());
		assertEquals(postUser.getFollowing(), user.getFollowing());
		assertEquals(postUser.getFavouritesCount(), user.getFavouritesCount());
		assertTrue(postUser.isProtected() == user.isProtected());
		assertEquals(postUser.getProfileTextColor(), user.getProfileTextColor());
		assertTrue(postUser.isVerified() == user.isVerified());
		assertTrue(postUser.isContributorsEnabled() == user.isContributorsEnabled());
		assertEquals(postUser.getDescription(), user.getDescription());
		assertEquals(postUser.getName(), user.getName());
		assertEquals(postUser.getProfileSidebarBorderColor(), user.getProfileSidebarBorderColor());
		assertEquals(postUser.getProfileBackgroundColor(), user.getProfileBackgroundColor());
		assertEquals(postUser.getCreatedAt().getTime(), user.getCreatedAt().getTime());
		assertTrue(postUser.isDefaultProfileImage() == user.isDefaultProfileImage());
		assertEquals(postUser.getFollowersCount(), user.getFollowersCount());
		assertTrue(postUser.isGeoEnabled() == user.isGeoEnabled());
		assertTrue(postUser.getProfileBackgroundImageUrl().equals(user.getProfileBackgroundImageUrl()));
		assertTrue(postUser.getProfileBackgroundImageUrlHttps().equals(user.getProfileBackgroundImageUrlHttps()));
		assertTrue(postUser.isFollowRequestSent() == user.isFollowRequestSent());
		assertTrue(postUser.getUrl().equals(user.getUrl()));
		assertTrue(postUser.getTimeZone().equals(user.getTimeZone()));
		assertEquals(postUser.getNotifications(), user.getNotifications());
		assertTrue(postUser.isProfileUseBackgroundImage() == user.isProfileUseBackgroundImage());
		assertEquals(postUser.getFriendsCount(), user.getFriendsCount());
		assertEquals(postUser.getProfileSideBarFillColor(), user.getProfileSideBarFillColor());
		assertEquals(postUser.getScreenName(), user.getScreenName());
		assertTrue(postUser.getProfileImageUrl().equals(user.getProfileImageUrl()));
		assertTrue(postUser.getProfileImageUrlHttps().equals(user.getProfileImageUrlHttps()));
		assertTrue(postUser.isShowAllInlineMedia() == user.isShowAllInlineMedia());
		assertTrue(postUser.isTranslator() == user.isTranslator());
		assertEquals(postUser.getListedCount(), user.getListedCount());
	}
	
	@Override
	public void testDelete() {
		user.save();
		assertEquals(1, userDao.count());
		user.delete();
		assertEquals(0, userDao.count());
	}

	@Override
	public void testExists() {
		user.save();
		assertTrue(userDao.exists(user));
	}
	
}
