package toctep.skynet.backend.test.dal;

import java.util.Date;

import toctep.skynet.backend.dal.domain.Geo;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.SourceType;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.User;

public class TweetTest extends DomainTest {

	@Override
	public void testCreate() {
		Tweet tweet = new Tweet();
		assertNotNull(tweet);
		
		String text = "test";
		tweet.setText(text);
		assertTrue(text.equals(tweet.getText()));
		
		Geo geo = new Geo();
		tweet.setGeo(geo);
		assertTrue(geo.equals(tweet.getGeo()));
		
		boolean truncated = false;
		tweet.setTruncated(truncated);
		assertTrue(truncated == tweet.isTruncated());
		
		long twitterId = 0L;
		tweet.setTwitterId(twitterId);
		assertEquals(twitterId, tweet.getTwitterId());
		
		SourceType sourceType = new SourceType();
		tweet.setSourceType(sourceType);
		assertTrue(sourceType.equals(tweet.getSourceType()));
		
		boolean favorited = false;
		tweet.setFavorited(favorited);
		assertTrue(favorited == tweet.isFavorited());
		
		long inReplyToTweetTwitterId = 0L;
		tweet.setInReplyToTweetTwitterId(inReplyToTweetTwitterId);
		assertEquals(inReplyToTweetTwitterId, tweet.getInReplyToTweetTwitterId());
		
		long inReplyToUserTwitterId = 0L;
		tweet.setInReplyToUserTwitterId(inReplyToUserTwitterId);
		assertEquals(inReplyToUserTwitterId, tweet.getInReplyToUserTwitterId());
		
		long retweetCount = 0L;
		tweet.setRetweetCount(retweetCount);
		assertEquals(retweetCount, tweet.getRetweetCount());
		
		Date createdAt = new Date();
		tweet.setCreatedAt(createdAt);
		assertTrue(createdAt.equals(tweet.getCreatedAt()));
		
		Place place = new Place();
		tweet.setPlace(place);
		assertTrue(place.equals(tweet.getPlace()));
		
		User user = new User();
		tweet.setUser(user);
		assertTrue(user.equals(tweet.getUser()));
		
		String coordinates = "test";
		tweet.setCoordinates(coordinates);
		assertTrue(coordinates.equals(tweet.getCoordinates()));
	}
	
	@Override
	public void testInsert() {
		Tweet preTweet = new Tweet();
		
		String text = "test";
		preTweet.setText(text);
		
		Geo geo = new Geo();
		preTweet.setGeo(geo);
		
		boolean truncated = false;
		preTweet.setTruncated(truncated);
		
		long twitterId = 0L;
		preTweet.setTwitterId(twitterId);
		
		SourceType sourceType = new SourceType();
		preTweet.setSourceType(sourceType);
		
		boolean favorited = false;
		preTweet.setFavorited(favorited);
		
		long inReplyToTweetTwitterId = 0L;
		preTweet.setInReplyToTweetTwitterId(inReplyToTweetTwitterId);
		
		long inReplyToUserTwitterId = 0L;
		preTweet.setInReplyToUserTwitterId(inReplyToUserTwitterId);
		
		long retweetCount = 0L;
		preTweet.setRetweetCount(retweetCount);
		
		Date createdAt = new Date();
		preTweet.setCreatedAt(createdAt);
		
		Place place = new Place();
		preTweet.setPlace(place);
		
		User user = new User();
		preTweet.setUser(user);
		
		String coordinates = "test";
		preTweet.setCoordinates(coordinates);
		
		tweetDao.insert(preTweet);
		assertEquals(1, tweetDao.count());
		
		Tweet postTweet = (Tweet) tweetDao.select(preTweet.getId());
		
		assertTrue(postTweet.getText().equals(preTweet.getText()));
		assertTrue(postTweet.getGeo().equals(preTweet.getGeo()));
		assertTrue(postTweet.isTruncated() == preTweet.isTruncated());
		assertEquals(postTweet.getTwitterId(), preTweet.getTwitterId());
		assertTrue(postTweet.getSourceType().equals(preTweet.getSourceType()));
		assertTrue(postTweet.isFavorited() == preTweet.isFavorited());
		assertEquals(postTweet.getInReplyToTweetTwitterId(), preTweet.getInReplyToTweetTwitterId());
		assertEquals(postTweet.getInReplyToUserTwitterId(), preTweet.getInReplyToUserTwitterId());
		assertEquals(postTweet.getRetweetCount(), preTweet.getRetweetCount());
		assertTrue(postTweet.getCreatedAt().equals(preTweet.getCreatedAt()));
		assertTrue(postTweet.getPlace().equals(preTweet.getPlace()));
		assertTrue(postTweet.getUser().equals(preTweet.getUser()));
		assertTrue(postTweet.getCoordinates().equals(preTweet.getCoordinates()));
	}
	
	@Override
	public void testSelect() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testUpdate() {
		// TODO
	}
	
	@Override
	public void testDelete() {
		Tweet tweet = new Tweet();
		assertNotNull(tweet);
		tweetDao.insert(tweet);
		assertEquals(1, tweetDao.count());
		tweetDao.delete(tweet);
		assertEquals(0, tweetDao.count());
	}

}
