package toctep.skynet.backend.dal.domain.user;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;


public class NullUser implements IUser {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public Date getCreatedAt() {
		return new java.sql.Date(0);
	}

	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public int getFavouritesCount() {
		return 0;
	}

	@Override
	public int getFollowersCount() {
		return 0;
	}

	@Override
	public int getFollowing() {
		return 0;
	}

	@Override
	public int getFriendsCount() {
		return 0;
	}

	@Override
	public ILanguage getLanguage() {
		return new NullLanguage();
	}

	@Override
	public int getListedCount() {
		return 0;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public long getNotifications() {
		return 0;
	}

	@Override
	public IPlace getPlace() {
		return new NullPlace();
	}

	@Override
	public String getProfileBackgroundColor() {
		return "";
	}

	@Override
	public IUrl getProfileBackgroundImageUrl() {
		return new NullUrl();
	}

	@Override
	public IUrl getProfileBackgroundImageUrlHttps() {
		return new NullUrl();
	}

	@Override
	public long getProfileBackgroundTile() {
		return 0;
	}

	@Override
	public IUrl getProfileImageUrl() {
		return new NullUrl();
	}

	@Override
	public IUrl getProfileImageUrlHttps() {
		return new NullUrl();
	}

	@Override
	public String getProfileLinkColor() {
		return "";
	}

	@Override
	public String getProfileSideBarFillColor() {
		return "";
	}

	@Override
	public String getProfileSidebarBorderColor() {
		return "";
	}

	@Override
	public String getProfileTextColor() {
		return "";
	}

	@Override
	public String getScreenName() {
		return "";
	}

	@Override
	public int getStatusesCount() {
		return 0;
	}

	@Override
	public ITimeZone getTimeZone() {
		return new NullTimeZone();
	}

	@Override
	public IUrl getUrl() {
		return new NullUrl();
	}

	@Override
	public boolean isContributorsEnabled() {
		return false;
	}

	@Override
	public boolean isDefaultProfile() {
		return false;
	}

	@Override
	public boolean isDefaultProfileImage() {
		return false;
	}

	@Override
	public boolean isFollowRequestSent() {
		return false;
	}

	@Override
	public boolean isGeoEnabled() {
		return false;
	}

	@Override
	public boolean isProfileUseBackgroundImage() {
		return false;
	}

	@Override
	public boolean isProtected() {
		return false;
	}

	@Override
	public boolean isShowAllInlineMedia() {
		return false;
	}

	@Override
	public boolean isTranslator() {
		return false;
	}

	@Override
	public boolean isVerified() {
		return false;
	}

}