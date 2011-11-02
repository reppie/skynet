package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.tweet.Tweet;

public class TweetDaoImpl extends TweetDao {
	
	@Override
	public void insert(Domain<Long> domain) {
		Tweet tweet = (Tweet) domain;
		
		String query = 
			"INSERT INTO " + tableName + 
				"(id, text, geo_id, truncated, source_type_id, favorited, in_reply_to_tweet_id, in_reply_to_user_id, retweet_count, created_at, place_id, user_id, coordinates) " +
			"VALUES" +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT),
			new Param(tweet.getText(), Types.VARCHAR),
			new Param(tweet.getGeo().getId(), Types.BIGINT),
			new Param(tweet.isTruncated(), Types.BOOLEAN),
			new Param(tweet.getSourceType().getId(), Types.BIGINT),
			new Param(tweet.isFavorited(), Types.BOOLEAN),
			new Param(tweet.getInReplyToTweetTwitter().getId(), Types.BIGINT),
			new Param(tweet.getInReplyToUserTwitter().getId(), Types.BIGINT),
			new Param(tweet.getRetweetCount(), Types.INTEGER),
			new Param(tweet.getCreatedAt(), Types.DATE),
			new Param(tweet.getPlace().getId(), Types.VARCHAR),
			new Param(tweet.getUser().getId(), Types.BIGINT),
			new Param(tweet.getCoordinates(), Types.VARCHAR)
		};
			
		MySqlUtil.getInstance().insert(query, params);
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
