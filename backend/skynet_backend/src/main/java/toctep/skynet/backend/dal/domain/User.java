package toctep.skynet.backend.dal.domain;

import java.util.Date;

public class User extends Domain {

	private long twitterId;
	private Place place;
	private boolean defaultProfile;
	private long statusesCount;
	private long profileBackgroundTile;
	private Language language;
	private String profileLinkColor;
	private long following;
	private long favouritesCount;
	private boolean isProtected;
	private String profileTextColor;
	private boolean verified;
	private boolean contributorsEnabled;
	private String description;
	private String name;
	private String profileSidebarBorderColor;
	private String profileBackgroundColor;
	private Date createdAt;
	private boolean defaultProfileImage;
	private long followersCount;
	private boolean geoEnabled;
	private String profileBackgroundImageUrl;
	private String profileBackgroundImageUrlHttps;
	private boolean followRequestSent;
	private String url;
	private TimeZone timeZone;
	private long notifications;
	private boolean profileUseBackgroundImage;
	private long friendsCount;
	private String profileSideBarFillColor;
	private String screenName;
	private String profileImageUrl;
	private boolean showAllInlineMedia;
	private boolean isTranslator;
	private long listedCount;
	
	public User() {
		super();
	}
	
	public User(int id, String name) {
		super(id);
		this.name = name;
	}
	
	public User(int id, long twitterId, Place place, boolean defaultProfile,
			int statusesCount, long profileBackgroundTile, Language language,
			String profileLinkColor, long following, long favouritesCount,
			boolean isProtected, String profileTextColor, boolean verified,
			boolean contributorsEnabled, String description, String name,
			String profileSidebarBorderColor, String profileBackgroundColor,
			Date createdAt, boolean defaultProfileImage, int followersCount,
			boolean geoEnabled, String profileBackgroundImageUrl,
			String profileBackgroundImageUrlHttps, boolean followRequestSent,
			String url, TimeZone timeZone, long notifications,
			boolean profileUseBackgroundImage, long friendsCount,
			String profileSideBarFillColor, String screenName,
			String profileImageUrl, boolean showAllInlineMedia,
			boolean isTranslator, long listedCount) {
		super(id);
		this.twitterId = twitterId;
		this.place = place;
		this.defaultProfile = defaultProfile;
		this.statusesCount = statusesCount;
		this.profileBackgroundTile = profileBackgroundTile;
		this.language = language;
		this.profileLinkColor = profileLinkColor;
		this.following = following;
		this.favouritesCount = favouritesCount;
		this.isProtected = isProtected;
		this.profileTextColor = profileTextColor;
		this.verified = verified;
		this.contributorsEnabled = contributorsEnabled;
		this.description = description;
		this.name = name;
		this.profileSidebarBorderColor = profileSidebarBorderColor;
		this.profileBackgroundColor = profileBackgroundColor;
		this.createdAt = createdAt;
		this.defaultProfileImage = defaultProfileImage;
		this.followersCount = followersCount;
		this.geoEnabled = geoEnabled;
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
		this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
		this.followRequestSent = followRequestSent;
		this.url = url;
		this.timeZone = timeZone;
		this.notifications = notifications;
		this.profileUseBackgroundImage = profileUseBackgroundImage;
		this.friendsCount = friendsCount;
		this.profileSideBarFillColor = profileSideBarFillColor;
		this.screenName = screenName;
		this.profileImageUrl = profileImageUrl;
		this.showAllInlineMedia = showAllInlineMedia;
		this.isTranslator = isTranslator;
		this.listedCount = listedCount;
	}

	public long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(long twitterId) {
		this.twitterId = twitterId;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public boolean isDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(boolean defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public long getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(long statusesCount) {
		this.statusesCount = statusesCount;
	}

	public long getProfileBackgroundTile() {
		return profileBackgroundTile;
	}

	public void setProfileBackgroundTile(long profileBackgroundTile) {
		this.profileBackgroundTile = profileBackgroundTile;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getProfileLinkColor() {
		return profileLinkColor;
	}

	public void setProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
	}

	public long getFollowing() {
		return following;
	}

	public void setFollowing(long following) {
		this.following = following;
	}

	public long getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(long favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public String getProfileTextColor() {
		return profileTextColor;
	}

	public void setProfileTextColor(String profileTextColor) {
		this.profileTextColor = profileTextColor;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isContributorsEnabled() {
		return contributorsEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileSidebarBorderColor() {
		return profileSidebarBorderColor;
	}

	public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
		this.profileSidebarBorderColor = profileSidebarBorderColor;
	}

	public String getProfileBackgroundColor() {
		return profileBackgroundColor;
	}

	public void setProfileBackgroundColor(String profileBackgroundColor) {
		this.profileBackgroundColor = profileBackgroundColor;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isDefaultProfileImage() {
		return defaultProfileImage;
	}

	public void setDefaultProfileImage(boolean defaultProfileImage) {
		this.defaultProfileImage = defaultProfileImage;
	}

	public long getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(long followersCount) {
		this.followersCount = followersCount;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public String getProfileBackgroundImageUrl() {
		return profileBackgroundImageUrl;
	}

	public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
	}

	public String getProfileBackgroundImageUrlHttps() {
		return profileBackgroundImageUrlHttps;
	}

	public void setProfileBackgroundImageUrlHttps(
			String profileBackgroundImageUrlHttps) {
		this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
	}

	public boolean isFollowRequestSent() {
		return followRequestSent;
	}

	public void setFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public long getNotifications() {
		return notifications;
	}

	public void setNotifications(long notifications) {
		this.notifications = notifications;
	}

	public boolean isProfileUseBackgroundImage() {
		return profileUseBackgroundImage;
	}

	public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
		this.profileUseBackgroundImage = profileUseBackgroundImage;
	}

	public long getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

	public String getProfileSideBarFillColor() {
		return profileSideBarFillColor;
	}

	public void setProfileSideBarFillColor(String profileSideBarFillColor) {
		this.profileSideBarFillColor = profileSideBarFillColor;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public boolean isShowAllInlineMedia() {
		return showAllInlineMedia;
	}

	public void setShowAllInlineMedia(boolean showAllInlineMedia) {
		this.showAllInlineMedia = showAllInlineMedia;
	}

	public boolean isTranslator() {
		return isTranslator;
	}

	public void setTranslator(boolean isTranslator) {
		this.isTranslator = isTranslator;
	}

	public long getListedCount() {
		return listedCount;
	}

	public void setListedCount(long listedCount) {
		this.listedCount = listedCount;
	}
	
}
