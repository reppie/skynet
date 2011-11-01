package toctep.skynet.backend.dal.domain.user;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;

public interface IUser{

	public IPlace getPlace();
	public boolean isDefaultProfile();
	public int getStatusesCount();
	public long getProfileBackgroundTile();
	public ILanguage getLanguage();
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
	public IUrl getProfileBackgroundImageUrl();
	public IUrl getProfileBackgroundImageUrlHttps();
	public boolean isFollowRequestSent();
	public IUrl getUrl();
	public ITimeZone getTimeZone();
	public long getNotifications();
	public boolean isProfileUseBackgroundImage();
	public int getFriendsCount();
	public String getProfileSideBarFillColor();
	public String getScreenName();
	public IUrl getProfileImageUrl();
	public IUrl getProfileImageUrlHttps();
	public boolean isShowAllInlineMedia();
	public boolean isTranslator();
	public int getListedCount();
}
