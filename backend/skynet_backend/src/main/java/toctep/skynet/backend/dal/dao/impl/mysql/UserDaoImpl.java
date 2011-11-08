package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.dal.domain.user.IUser;
import toctep.skynet.backend.dal.domain.user.NullUser;
import toctep.skynet.backend.dal.domain.user.User;

public class UserDaoImpl extends UserDao {

	@Override
	public void insert(Domain<Long> domain) {
		User user = (User) domain;
		
		String query = 
			"INSERT INTO " + TABLE_NAME + 
				"(id, place_id, default_profile, statuses_count, profile_background_tile, language_id, profile_link_color, following, favourites_count, protected, " +
				"profile_text_color, verified, contributors_enabled, description, name, profile_sidebar_border_color, profile_background_color, created_at, default_profile_image, " +
				"followers_count, profile_image_url_id, profile_image_url_https_id, geo_enabled, profile_background_image_url_id, profile_background_image_url_https_id, " +
				"follow_request_sent, url_id, time_zone_id, notifications, profile_use_background_image, friends_count, profile_sidebar_fill_color, screen_name, show_all_inline_media," +
				"is_translator, listed_count) " +
			"VALUES" +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
				 "?, ?, ?, ?, ?, ?, ?, ?, ?, " +
				 "?, ?, ?, ?, ?, ?, " +
				 "?, ?, ?, ?, ?, ?, ?, ?, ?, " +
				 "?, ?)";
			
		Param[] params = new Param[] {
			new Param(user.getId(), Types.BIGINT),
			new Param(user.getPlace().getId(), Types.VARCHAR),
			new Param(user.isDefaultProfile(), Types.BOOLEAN),
			new Param(user.getStatusesCount(), Types.INTEGER),
			new Param(user.isProfileBackgroundTiled(), Types.BOOLEAN),
			new Param(user.getLanguage().getId(), Types.BIGINT),
			new Param(user.getProfileLinkColor(), Types.VARCHAR),
			new Param(user.getFollowing(), Types.INTEGER),
			new Param(user.getFavouritesCount(), Types.INTEGER),
			new Param(user.isProtected(), Types.BOOLEAN),
			
			new Param(user.getProfileTextColor(), Types.VARCHAR),
			new Param(user.isVerified(), Types.BOOLEAN),
			new Param(user.isContributorsEnabled(), Types.BOOLEAN),
			new Param(user.getDescription(), Types.VARCHAR),
			new Param(user.getName(), Types.VARCHAR),
			new Param(user.getProfileSidebarBorderColor(), Types.VARCHAR),
			new Param(user.getProfileBackgroundColor(), Types.VARCHAR),
			new Param(user.getCreatedAt(), Types.TIMESTAMP),
			new Param(user.isDefaultProfile(), Types.BOOLEAN),
			
			new Param(user.getFollowersCount(), Types.INTEGER),
			new Param(user.getProfileImageUrl().getId(), Types.VARCHAR),
			new Param(user.getProfileImageUrlHttps().getId(), Types.VARCHAR),
			new Param(user.isGeoEnabled(), Types.BOOLEAN),
			new Param(user.getProfileBackgroundImageUrl().getId(), Types.VARCHAR),
			new Param(user.getProfileBackgroundImageUrlHttps().getId(), Types.VARCHAR),
			
			new Param(user.isFollowRequestSent(), Types.BOOLEAN),
			new Param(user.getUrl().getId(), Types.VARCHAR),
			new Param(user.getTimeZone().getId(), Types.BIGINT),
			new Param(user.getNotifications(), Types.INTEGER),
			new Param(user.isProfileUseBackgroundImage(), Types.BOOLEAN),
			new Param(user.getFriendsCount(), Types.INTEGER),
			new Param(user.getProfileSideBarFillColor(), Types.VARCHAR),
			new Param(user.getScreenName(), Types.VARCHAR),
			new Param(user.isShowAllInlineMedia(), Types.BOOLEAN),
			
			new Param(user.isTranslator(), Types.BOOLEAN),
			new Param(user.getListedCount(), Types.INTEGER),
		};
				
		MySqlUtil.getInstance().insert(query, params);
	}
	
	@Override
	public User select(Long id) {
		User user = new User();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> record = MySqlUtil.getInstance().selectRow(query, params);
		
		user.setId(id);
		user.setPlace(Place.select((String) record.get("place_id")));
		user.setDefaultProfile((Boolean) record.get("default_profile"));
		user.setStatusesCount((Integer) record.get("statuses_count"));
		user.setProfileBackgroundTiled((Boolean) record.get("profile_background_tile"));
		user.setLanguage(Language.select((Integer) record.get("language_id")));
		user.setProfileLinkColor((String) record.get("profile_link_color"));
		user.setFollowing((Integer) record.get("following"));
		user.setFavouritesCount((Integer) record.get("favourites_count"));
		user.setProtected((Boolean) record.get("protected"));
				
		user.setProfileTextColor((String) record.get("profile_text_color"));
		user.setVerified((Boolean) record.get("verified"));
		user.setContributorsEnabled((Boolean) record.get("contributors_enabled"));
		user.setDescription((String) record.get("description"));
		user.setName((String) record.get("name"));
		user.setProfileSidebarBorderColor((String) record.get("profile_sidebar_border_color"));
		user.setProfileBackgroundColor((String) record.get("profile_background_color"));
		user.setCreatedAt((Timestamp) record.get("created_at"));
		user.setDefaultProfile((Boolean) record.get("default_profile_image"));
		
		user.setFollowersCount((Integer) record.get("followers_count"));
		user.setProfileImageUrl(Url.select((String) record.get("profile_image_url_id")));
		user.setProfileImageUrlHttps(Url.select((String) record.get("profile_image_url_https_id")));
		user.setGeoEnabled((Boolean) record.get("geo_enabled"));
		user.setProfileBackgroundImageUrl(Url.select((String) record.get("profile_background_image_url_id")));
		user.setProfileBackgroundImageUrlHttps(Url.select((String) record.get("profile_background_image_url_https_id")));
		
		user.setFollowRequestSent((Boolean) record.get("follow_request_sent"));
		user.setUrl(Url.select((String) record.get("url_id")));
		user.setTimeZone(TimeZone.select((Integer) record.get("time_zone_id")));
		user.setNotifications((Integer) record.get("notifications"));
		user.setProfileUseBackgroundImage((Boolean) record.get("profile_use_background_image"));
		user.setFriendsCount((Integer) record.get("friends_count"));
		user.setProfileSideBarFillColor((String) record.get("profile_sidebar_fill_color"));
		user.setScreenName((String) record.get("screen_name"));
		user.setShowAllInlineMedia((Boolean) record.get("show_all_inline_media"));
		
		user.setTranslator((Boolean) record.get("is_translator"));
		user.setListedCount((Integer) record.get("listed_count"));
		
		return user;
	}

	@Override
	public IUser select(String screenName) {
		String query = "SELECT id FROM " + TABLE_NAME + " WHERE screen_name=?";
		
		Param[] params = new Param[] {
			new Param(screenName, Types.VARCHAR)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		if (row.size() > 0) {
			return select((Long) row.get("id"));
		} else {
			return NullUser.getInstance();
		}
	}
	
	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		User user = (User) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(user.getId(), Types.BIGINT) }
		);
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		User user = (User) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(user.getId(), Types.BIGINT));
	}
	
	@Override
	public boolean exists(Long id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.BIGINT));
	}	

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
