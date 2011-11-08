package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;

public class TweetHashtagDaoImpl extends TweetHashtagDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;
		
		String query = "INSERT INTO " + TABLE_NAME + "(tweet_id, hashtag_id) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetHashtag.getTweet().getId(), Types.BIGINT),
			new Param(tweetHashtag.getHashtag().getId(), Types.INTEGER)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetHashtag.setId(id);
	}

	@Override
	public TweetHashtag select(Integer id) {
		TweetHashtag tweetHashtag = new TweetHashtag();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		tweetHashtag.setId(id);
		tweetHashtag.setTweet(Tweet.select((Long) row.get("tweet_id")));
		tweetHashtag.setHashtag(Hashtag.select((Integer) row.get("hashtag_id")));
		
		return tweetHashtag;
	}
	
	public List<TweetHashtag> select(Tweet tweet) {
		List<TweetHashtag> tweetHashtags = new ArrayList<TweetHashtag>();
		
		String query = "SELECT id, hashtag_id FROM " + TABLE_NAME + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<Map<String, Object>> rows = MySqlUtil.getInstance().select(query, params);
		
		for(Map<String, Object> row : rows) {
			TweetHashtag tweetHashtag = new TweetHashtag();
			tweetHashtag.setId((Integer) row.get("id"));
			tweetHashtag.setTweet(tweet);
			tweetHashtag.setHashtag(Hashtag.select((Integer) row.get("hashtag_id")));
			tweetHashtags.add(tweetHashtag);
		}
		return tweetHashtags;
	}	

	@Override
	public void update(Domain<Integer> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;	
		MySqlUtil.getInstance().delete(
				"DELETE FROM " + TABLE_NAME + " WHERE id=?",
				new Param[] { new Param(tweetHashtag.getId(), Types.INTEGER) }
			);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(tweetHashtag.getId(), Types.INTEGER));
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.INTEGER));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
