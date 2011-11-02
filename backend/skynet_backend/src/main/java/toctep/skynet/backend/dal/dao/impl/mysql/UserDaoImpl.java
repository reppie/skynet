package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.user.User;

public class UserDaoImpl extends UserDao {

	@Override
	public void insert(Domain<Long> domain) {
		User user = (User) domain;
		
		String query = 
			"INSERT INTO " + tableName + 
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
			new Param(user.getProfileBackgroundTile(), Types.BIGINT),
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
			new Param(user.getCreatedAt(), Types.DATE),
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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		user.setId(id);
		user.setName((String) record.get(1));
		
		return user;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain<Long> domain) {
		User user = (User) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + user.getId());	
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		User user = (User) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + user.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
