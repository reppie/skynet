package toctep.skynet.backend.dal.domain.user;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.Language;
import toctep.skynet.backend.dal.domain.TimeZone;
import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.place.Place;

public interface IUser{

	public Place getPlace();
	public boolean isDefaultProfile();
	public int getStatusesCount();
	public long getProfileBackgroundTile();
	public Language getLanguage();
	public String getProfileLinkColor();
	public int getFollowing();
	public int getFavouritesCount();
	public boolean isProtected();
	public String getProfileTextColor();
	public boolean isVerified();
	public boolean isContributorsEnabled();
	public String getDescription();
	public String getName();
	public String getProfileSidebarBorderColor();
	public String getProfileBackgroundColor();
	public Date getCreatedAt();
	public boolean isDefaultProfileImage();
	public int getFollowersCount();
	public boolean isGeoEnabled();
	public Url getProfileBackgroundImageUrl();
	public Url getProfileBackgroundImageUrlHttps();
	public boolean isFollowRequestSent();
	public Url getUrl();
	public TimeZone getTimeZone();
	public long getNotifications();
	public boolean isProfileUseBackgroundImage();
	public int getFriendsCount();
	public String getProfileSideBarFillColor();
	public String getScreenName();
	public Url getProfileImageUrl();
	public Url getProfileImageUrlHttps();
	public boolean isShowAllInlineMedia();
	public boolean isTranslator();
	public int getListedCount();
}
