package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import toctep.skynet.backend.dal.dao.UserDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.User;

public class UserDaoImpl extends UserDao {

	@Override
	public void insert(Domain domain) {
		User user = (User) domain;
		
		String query = 
			"INSERT INTO " + tableName + " " +
			"VALUES " +
				"(" +
					user.getId() + "," +
					MySqlUtil.escape(user.getPlace().getId()) + "," +
					user.isDefaultProfile() + "," +
					user.getStatusesCount() + "," +
					user.getProfileBackgroundTile() + "," +
					user.getLanguage().getId() + "," +
					MySqlUtil.escape(user.getProfileLinkColor()) + "," +
					user.getFollowing() + "," +
					user.getFavouritesCount() + "," +
					user.isProtected() + "," +
					MySqlUtil.escape(user.getProfileTextColor()) + "," +
					user.isVerified() + "," +
					user.isContributorsEnabled() + "," +
					MySqlUtil.escape(user.getDescription()) + "," +
					MySqlUtil.escape(user.getName()) + "," +
					MySqlUtil.escape(user.getProfileSidebarBorderColor()) + "," +
					MySqlUtil.escape(user.getProfileBackgroundColor()) + "," +
					MySqlUtil.escape(user.getCreatedAt().toString()) + "," +
					user.isDefaultProfileImage() + "," +
					user.getFollowersCount() + "," +
					MySqlUtil.escape(user.getProfileImageUrl()) + "," +
					MySqlUtil.escape(user.getProfileImageUrlHttps()) + "," +
					user.isGeoEnabled() + "," +
					MySqlUtil.escape(user.getProfileBackgroundImageUrl()) + "," +
					MySqlUtil.escape(user.getProfileBackgroundImageUrlHttps()) + "," +
					user.isFollowRequestSent() + "," +
					MySqlUtil.escape(user.getUrl().getId()) + "," +
					user.getTimeZone().getId() + "," +
					user.getNotifications() + "," +
					user.isProfileUseBackgroundImage() + "," +
					user.getFriendsCount() + "," +
					MySqlUtil.escape(user.getProfileSideBarFillColor()) + "," +
					MySqlUtil.escape(user.getScreenName()) + "," +
					user.isShowAllInlineMedia() + "," +
					user.isTranslator() + "," +
					user.getListedCount() +
				")";
		
		MySqlUtil.getInstance().insert(query);
	}
	
	@Override
	public User select(long id) {
		User user = new User();
		
		ResultSet rs = MySqlUtil.getInstance().select(
			"SELECT name FROM " + tableName + " WHERE id = " + id
		);
		
		user.setId(id);
		
		try {
			user.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void update(Domain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Domain domain) {
		User user = (User) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + user.getId());	
	}

	@Override
	public boolean exists(Domain domain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
