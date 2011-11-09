package toctep.skynet.backend.dal.domain.user;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;

public class User extends Domain<Long> implements IUser {

	private IPlace place 						= NullPlace.getInstance();
	private boolean defaultProfile				= false;
	private int statusesCount					= 0;	
	private boolean profileBackgroundTiled		= false;
	private ILanguage language 					= NullLanguage.getInstance();
	private String profileLinkColor				= "";
	private int following						= 0;
	private int favouritesCount					= 0;
	private boolean isProtected					= false;
	private String profileTextColor				= "";
	private boolean verified					= false;
	private boolean contributorsEnabled			= false;
	private String description					= "";
	private String name							= "";
	private String profileSidebarBorderColor	= "";
	private String profileBackgroundColor		= "";
	private Timestamp createdAt					= new Timestamp(0);
	private boolean defaultProfileImage			= false;
	private int followersCount					= 0;
	private boolean geoEnabled					= false;
	private IUrl profileBackgroundImageUrl 		= NullUrl.getInstance();
	private IUrl profileBackgroundImageUrlHttps = NullUrl.getInstance();
	private boolean followRequestSent			= false;
	private IUrl url 							= NullUrl.getInstance();
	private ITimeZone timeZone 					= NullTimeZone.getInstance();
	private int notifications					= 0;
	private boolean profileUseBackgroundImage	= false;
	private int friendsCount					= 0;
	private String profileSideBarFillColor		= "";
	private String screenName					= "";
	private IUrl profileImageUrl 				= NullUrl.getInstance();
	private IUrl profileImageUrlHttps 			= NullUrl.getInstance();
	private boolean showAllInlineMedia			= false;
	private boolean isTranslator				= false;
	private int listedCount						= 0;

	public User() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getUserDao());
	}
	
	public IPlace getPlace() {
		return place;
	}

	public void setPlace(IPlace place) {
		this.place = place;
	}

	public boolean isDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(boolean defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public boolean isProfileBackgroundTiled() {
		return profileBackgroundTiled;
	}

	public void setProfileBackgroundTiled(boolean profileBackgroundTiled) {
		this.profileBackgroundTiled = profileBackgroundTiled;
	}

	public ILanguage getLanguage() {
		return language;
	}

	public void setLanguage(ILanguage language) {
		this.language = language;
	}

	public String getProfileLinkColor() {
		return profileLinkColor;
	}

	public void setProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isDefaultProfileImage() {
		return defaultProfileImage;
	}

	public void setDefaultProfileImage(boolean defaultProfileImage) {
		this.defaultProfileImage = defaultProfileImage;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public IUrl getProfileBackgroundImageUrl() {
		return profileBackgroundImageUrl;
	}

	public void setProfileBackgroundImageUrl(IUrl profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
	}

	public IUrl getProfileBackgroundImageUrlHttps() {
		return profileBackgroundImageUrlHttps;
	}

	public void setProfileBackgroundImageUrlHttps(
			IUrl profileBackgroundImageUrlHttps) {
		this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
	}

	public boolean isFollowRequestSent() {
		return followRequestSent;
	}

	public void setFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
	}

	public IUrl getUrl() {
		return url;
	}

	public void setUrl(IUrl url) {
		this.url = url;
	}

	public ITimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(ITimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public int getNotifications() {
		return notifications;
	}

	public void setNotifications(int notifications) {
		this.notifications = notifications;
	}

	public boolean isProfileUseBackgroundImage() {
		return profileUseBackgroundImage;
	}

	public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
		this.profileUseBackgroundImage = profileUseBackgroundImage;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
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

	public IUrl getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(IUrl profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	
	public IUrl getProfileImageUrlHttps() {
		return profileImageUrlHttps;
	}	
	
	public void setProfileImageUrlHttps(IUrl profileImageUrlHttps) {
		this.profileImageUrlHttps = profileImageUrlHttps;
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

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}
	
	@Override
	public void save() {
		place.save();	
		language.save();
		url.save();
		timeZone.save();
		profileBackgroundImageUrl.save();
		profileBackgroundImageUrlHttps.save();
		profileImageUrl.save();
		profileImageUrlHttps.save();
		
		super.save();
	}
	
	public static IUser select(Long id) {
		UserDao dao = DaoFacadeImpl.getInstance().getUserDao();
		
		if (dao.exists(id)) {
			return (User) dao.select(id);
		}
		
		return NullUser.getInstance();
	}
	
	public static IUser select(String screenName) {
		UserDao dao = DaoFacadeImpl.getInstance().getUserDao();
		return dao.select(screenName);
	}	
	
	public static boolean exists(Long id) {
		UserDao dao = DaoFacadeImpl.getInstance().getUserDao();
		if (dao.exists(id)) {
			return true;
		}
		return false;
	}
	
}
