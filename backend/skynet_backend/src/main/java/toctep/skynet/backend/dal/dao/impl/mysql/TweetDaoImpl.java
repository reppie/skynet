package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.sourcetype.SourceType;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;
import toctep.skynet.backend.dal.domain.tweet.TweetUrl;
import toctep.skynet.backend.dal.domain.user.User;

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
			new Param(tweet.getCreatedAt(), Types.TIMESTAMP),
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
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweet.setId(id);
		tweet.setText((String) row.get("text"));
		tweet.setGeo(Geo.select((Integer) row.get("geo_id")));
		tweet.setTruncated((Boolean) row.get("truncated"));
		tweet.setSourceType(SourceType.select((Integer) row.get("source_type_id")));
		tweet.setFavorited((Boolean) row.get("favorited"));
		tweet.setInReplyToTweetTwitter(Tweet.select((Long) row.get("in_reply_to_tweet_id")));
		tweet.setInReplyToUserTwitter(User.select((Long) row.get("in_reply_to_user_id")));
		tweet.setRetweetCount((Integer) row.get("retweet_count"));
		tweet.setCreatedAt((Timestamp) row.get("created_at"));
		tweet.setPlace(Place.select((String) row.get("place_id")));
		tweet.setUser(User.select((Long) row.get("user_id")));
		tweet.setCoordinates((String) row.get("coordinates"));
		
		List<TweetContributor> tweetContributors = TweetContributor.select(tweet);
		for (TweetContributor tweetContributor : tweetContributors) {
			tweet.addContributor(tweetContributor.getUser());
		}
		
		List<TweetHashtag> tweetHashtags = TweetHashtag.select(tweet);
		for (TweetHashtag tweetHashtag : tweetHashtags) {
			tweet.addHashtag(tweetHashtag.getHashtag());
		}
		
		List<TweetKeyword> tweetKeywords = TweetKeyword.select(tweet);
		for (TweetKeyword tweetKeyword : tweetKeywords) {
			tweet.addKeyword(tweetKeyword.getKeyword());
		}
		
		List<TweetMention> tweetMentions = TweetMention.select(tweet);
		for (TweetMention tweetMention : tweetMentions) {
			tweet.addMention(tweetMention.getUser());
		}
		
		List<TweetUrl> tweetUrls = TweetUrl.select(tweet);
		for (TweetUrl tweetUrl : tweetUrls) {
			tweet.addUrl(tweetUrl.getUrl());
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
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + tableName + " WHERE id=?",
			new Param[] { new Param(tweet.getId(), Types.BIGINT) }
		);
	}

	@Override
	public boolean exists(Domain<Long> domain) {
		Tweet tweet = (Tweet) domain;
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(tweet.getId(), Types.BIGINT));
	}
	
	@Override
	public boolean exists(Long id) {
		return MySqlUtil.getInstance().exists(tableName, "id", new Param(id, Types.BIGINT));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
