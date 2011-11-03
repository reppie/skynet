package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetHashtag;

public class TweetHashtagDaoImpl extends TweetHashtagDao {

	@Override
	public void insert(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;
		
		String query = "INSERT INTO " + tableName + "(tweet_id, hashtag_id) VALUES(?, ?)";
		
		Param[] params = new Param[] {
			new Param(tweetHashtag.getTweet().getId(), Types.BIGINT),
			new Param(tweetHashtag.getHashtag().getId(), Types.BIGINT)
		};
			
		int id = MySqlUtil.getInstance().insert(query, params);
		
		tweetHashtag.setId(id);
	}

	@Override
	public TweetHashtag select(Integer id) {
		TweetHashtag tweetHashtag = new TweetHashtag();
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.BIGINT)
		};
		
		List<Object> record = MySqlUtil.getInstance().selectRecord(query, params);
		
		tweetHashtag.setId(id);
		tweetHashtag.setTweet(Tweet.select((Long) record.get(1)));
		tweetHashtag.setHashtag(Hashtag.select((Integer) record.get(2)));
		
		return tweetHashtag;
	}
	
	public List<TweetHashtag> select(Tweet tweet) {
		List<TweetHashtag> tweetHashtags = new ArrayList<TweetHashtag>();
		
		String query = "SELECT id, hashtag_id FROM " + tableName + " WHERE tweet_id=?";
		
		Param[] params = new Param[] {
			new Param(tweet.getId(), Types.BIGINT)
		};
		
		List<List<Object>> records = MySqlUtil.getInstance().select(query, params);
		
		for(List<Object> record : records) {
			TweetHashtag tweetHashtag = new TweetHashtag();
			tweetHashtag.setId((Integer) record.get(0));
			tweetHashtag.setTweet(tweet);
			tweetHashtag.setHashtag(Hashtag.select((Integer) record.get(1)));
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
				"DELETE FROM " + tableName + " WHERE id=?",
				new Param[] { new Param(tweetHashtag.getId(), Types.INTEGER) }
			);
	}

	@Override
	public boolean exists(Domain<Integer> domain) {
		TweetHashtag tweetHashtag = (TweetHashtag) domain;
		return this.exists(tweetHashtag.getId());
	}
	
	@Override
	public boolean exists(Integer id) {
		return MySqlUtil.getInstance().exists(tableName, "id=" + id);
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
