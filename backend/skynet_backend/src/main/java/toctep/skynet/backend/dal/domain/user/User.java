package toctep.skynet.backend.dal.domain.user;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class User extends Domain<Long> implements IUser  {

	private IPlace place 						= new NullPlace();
	private boolean defaultProfile				= false;
	private int statusesCount					= 0;	
	private long profileBackgroundTile			= 0L;
	private ILanguage language 					= new NullLanguage();
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
	private Date createdAt						= new Date(0);
	private boolean defaultProfileImage			= false;
	private int followersCount					= 0;
	private boolean geoEnabled					= false;
	private IUrl profileBackgroundImageUrl 		= new NullUrl();
	private IUrl profileBackgroundImageUrlHttps = new NullUrl();
	private boolean followRequestSent			= false;
	private IUrl url 							= new NullUrl();
	private ITimeZone timeZone 					= new NullTimeZone();
	private long notifications					= 0L;
	private boolean profileUseBackgroundImage	= false;
	private int friendsCount					= 0;
	private String profileSideBarFillColor		= "";
	private String screenName					= "";
	private IUrl profileImageUrl 				= new NullUrl();
	private IUrl profileImageUrlHttps 			= new NullUrl();
	private boolean showAllInlineMedia			= false;
	private boolean isTranslator				= false;
	private int listedCount						= 0;

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

	public long getProfileBackgroundTile() {
		return profileBackgroundTile;
	}

	public void setProfileBackgroundTile(long profileBackgroundTile) {
		this.profileBackgroundTile = profileBackgroundTile;
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
	public void setDao() {
		dao = getDaoFacade().getUserDao();
	}
	
	@Override
	public void save() {
		if(place instanceof Place) {
			((Place)place).save();	
			((Place)this.place).setId(((Place)place).getId());
		}
		
		if(language instanceof Language) {
			((Language)language).save();
			((Language)this.language).setId(((Language)language).getId());
		}
		
		if(url instanceof Url) {
			((Url)url).save();
			((Url)this.url).setId(((Url)url).getId());
		}
		
		if(timeZone instanceof TimeZone) {
			((TimeZone)timeZone).save();
			((TimeZone)this.timeZone).setId(((TimeZone)timeZone).getId());
		}
		
		if(profileBackgroundImageUrl instanceof Url) {
			((Url)profileBackgroundImageUrl).save();
			((Url)this.profileBackgroundImageUrl).setId(((Url)profileBackgroundImageUrl).getId());
		}
		
		if(profileBackgroundImageUrlHttps instanceof Url) {
			((Url)profileBackgroundImageUrlHttps).save();
			((Url)this.profileBackgroundImageUrlHttps).setId(((Url)profileBackgroundImageUrlHttps).getId());
		}
		
		if(profileImageUrl instanceof Url) {
			((Url)profileImageUrl).save();
			((Url)this.profileImageUrl).setId(((Url)profileImageUrl).getId());
		}
		
		if(profileImageUrlHttps instanceof Url) {
			((Url)profileImageUrlHttps).save();
			((Url)this.profileImageUrlHttps).setId(((Url)profileImageUrlHttps).getId());
		}
		
		super.save();
	}	
}
