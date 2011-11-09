package toctep.skynet.backend.dal.domain.user;

import java.sql.Timestamp;

import toctep.skynet.backend.dal.domain.NullDomain;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.timezone.ITimeZone;
import toctep.skynet.backend.dal.domain.timezone.NullTimeZone;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;

public final class NullUser extends NullDomain<Long> implements IUser {

	private static NullUser instance;
	
	public static NullUser getInstance() {
		if (instance == null) {
			instance = new NullUser();
		}
		return instance;
	}
	
	@Override
	public Timestamp getCreatedAt() {
		return new Timestamp(0);
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
		return NullLanguage.getInstance();
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
	public int getNotifications() {
		return 0;
	}

	@Override
	public IPlace getPlace() {
		return NullPlace.getInstance();
	}

	@Override
	public String getProfileBackgroundColor() {
		return "";
	}

	@Override
	public IUrl getProfileBackgroundImageUrl() {
		return NullUrl.getInstance();
	}

	@Override
	public IUrl getProfileBackgroundImageUrlHttps() {
		return NullUrl.getInstance();
	}

	@Override
	public boolean isProfileBackgroundTiled() {
		return false;
	}

	@Override
	public IUrl getProfileImageUrl() {
		return NullUrl.getInstance();
	}

	@Override
	public IUrl getProfileImageUrlHttps() {
		return NullUrl.getInstance();
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
		return NullTimeZone.getInstance();
	}

	@Override
	public IUrl getUrl() {
		return NullUrl.getInstance();
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
