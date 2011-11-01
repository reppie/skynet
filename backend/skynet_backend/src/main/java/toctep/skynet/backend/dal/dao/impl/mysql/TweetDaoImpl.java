package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.tweet.SourceType;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetDaoImpl extends TweetDao {
	
	@Override
	public void insert(Domain<Long> domain) {
		Tweet tweet = (Tweet) domain;
		
		String query = "INSERT INTO " + tableName +	" VALUES ("
		+ tweet.getId() + ", "
		+ MySqlUtil.escape(tweet.getText()) + ", "
		+ ((Geo) tweet.getGeo()).getId() + ", "
		+ tweet.isTruncated() + ", "
		+ ((SourceType) tweet.getSourceType()).getId() + ", "
		+ tweet.isFavorited() + ", "
		+ tweet.getInReplyToTweetTwitter().getId() + ", "
		+ tweet.getInReplyToUserTwitter().getId() + ", "
		+ tweet.getRetweetCount() + ", "
		+ MySqlUtil.escape(tweet.getCreatedAt().toString()) + ", "
		+ MySqlUtil.escape(((Place) tweet.getPlace()).getId()) + ", "
		+ ((User) tweet.getUser()).getId() + ", "
		+ MySqlUtil.escape(tweet.getCoordinates()) + ")";
		
		MySqlUtil.getInstance().insert(query);
	}

	@Override
	public Tweet select(Long id) {
		Tweet tweet = new Tweet();
		
		ResultSet rs = MySqlUtil.getInstance().select("SELECT id, text FROM " + tableName + " WHERE id = " + id);
		
		tweet.setId(id);
		
		try {
			tweet.setText(rs.getString("text"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tweet;
	}

	@Override
	public void update(Domain<Long> domain) {
		// TODO
	}
	
	@Override
	public void delete(Domain<Long> domain) {
		Tweet tweet = (Tweet) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + tweet.getId());
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		Tweet tweet = (Tweet) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + tweet.getId());
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
