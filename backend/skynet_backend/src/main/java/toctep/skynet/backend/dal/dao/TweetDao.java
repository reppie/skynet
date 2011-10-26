package toctep.skynet.backend.dal.dao;

import toctep.skynet.backend.dal.domain.Tweet;

public interface TweetDao {

	public void insertTweet(Tweet tweet);
	public Tweet selectTweet(int tweetId);
	public void updateTweet(Tweet tweet);
	public void deleteTweet(Tweet tweet);
	
}