package toctep.skynet.backend.dal.domain.user;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.domain.IDomain;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;

public interface IUser extends IDomain<Long> {

	IPlace getPlace();
	boolean isDefaultProfile();
	int getStatusesCount();
	boolean isProfileBackgroundTiled();
	ILanguage getLanguage();
	String getProfileLinkColor();
	int getFollowing();
	int getFavouritesCount();
	boolean isProtected();
	String getProfileTextColor();
	boolean isVerified();
	boolean isContributorsEnabled();
	String getDescription();
	String getName();
	String getProfileSidebarBorderColor();
	String getProfileBackgroundColor();
	Timestamp getCreatedAt();
	boolean isDefaultProfileImage();
	int getFollowersCount();
	boolean isGeoEnabled();
	IUrl getProfileBackgroundImageUrl();
	IUrl getProfileBackgroundImageUrlHttps();
	boolean isFollowRequestSent();
	IUrl getUrl();
	ITimeZone getTimeZone();
	int getNotifications();
	boolean isProfileUseBackgroundImage();
	int getFriendsCount();
	String getProfileSideBarFillColor();
	String getScreenName();
	IUrl getProfileImageUrl();
	IUrl getProfileImageUrlHttps();
	boolean isShowAllInlineMedia();
	boolean isTranslator();
	int getListedCount();
	
}
