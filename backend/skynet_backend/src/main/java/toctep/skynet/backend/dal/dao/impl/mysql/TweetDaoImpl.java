package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Date;
import java.sql.Types;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.NullGeo;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.tweet.NullSourceType;
import toctep.skynet.backend.dal.domain.tweet.NullTweet;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.user.NullUser;

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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().select(query, params);
		
		tweet.setId(id);
		tweet.setText((String) record.get(1));
		tweet.setGeo(new NullGeo()); //TODO
		tweet.setTruncated((Boolean) record.get(3));
		tweet.setSourceType(new NullSourceType()); //TODO
		tweet.setFavorited((Boolean) record.get(5));
		tweet.setInReplyToTweetTwitter(new NullTweet()); //TODO
		tweet.setInReplyToUserTwitter(new NullUser()); //TODO
		tweet.setRetweetCount((Integer) record.get(8));
		tweet.setCreatedAt((Date) record.get(9));
		tweet.setPlace(new NullPlace()); //TODO
		tweet.setUser(new NullUser()); //TODO
		tweet.setCoordinates((String) record.get(12));
		
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
