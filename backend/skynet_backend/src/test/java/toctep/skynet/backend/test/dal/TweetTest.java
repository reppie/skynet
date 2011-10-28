package toctep.skynet.backend.test.dal;

import java.util.Date;

import toctep.skynet.backend.dal.domain.Geo;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.SourceType;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.User;

public class TweetTest extends DomainTest {

	private Tweet tweet;
	
	private long id;
	private String text;
	private Geo geo;
	private boolean truncated;
	private long twitterId;
	private SourceType sourceType;
	private boolean favorited;
	private long inReplyToTweetTwitterId;
	private long inReplyToUserTwitterId;
	private long retweetCount;
	private Date createdAt;
	private Place place;
	private User user;
	private String coordinates;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweet = new Tweet();
		
		id = 0L;
		tweet.setId(id);
		
		text = "test";
		tweet.setText(text);
		
		geo = new Geo();
		tweet.setGeo(geo);
		
		truncated = false;
		tweet.setTruncated(truncated);
		
		twitterId = 0L;
		tweet.setTwitterId(twitterId);
		
		sourceType = new SourceType();
		tweet.setSourceType(sourceType);
		
		favorited = false;
		tweet.setFavorited(favorited);
		
		inReplyToTweetTwitterId = 0L;
		tweet.setInReplyToTweetTwitterId(inReplyToTweetTwitterId);
		
		inReplyToUserTwitterId = 0L;
		tweet.setInReplyToUserTwitterId(inReplyToUserTwitterId);
		
		retweetCount = 0L;
		tweet.setRetweetCount(retweetCount);
		
		createdAt = new Date();
		tweet.setCreatedAt(createdAt);
		
		place = new Place();
		tweet.setPlace(place);
		
		user = new User();
		tweet.setUser(user);
		
		coordinates = "test";
		tweet.setCoordinates(coordinates);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(tweet);
		assertEquals(id, tweet.getId());
		assertTrue(text.equals(tweet.getText()));
		assertTrue(geo.equals(tweet.getGeo()));
		assertTrue(truncated == tweet.isTruncated());
		assertEquals(twitterId, tweet.getTwitterId());
		assertTrue(sourceType.equals(tweet.getSourceType()));
		assertTrue(favorited == tweet.isFavorited());
		assertEquals(inReplyToTweetTwitterId, tweet.getInReplyToTweetTwitterId());
		assertEquals(inReplyToUserTwitterId, tweet.getInReplyToUserTwitterId());
		assertEquals(retweetCount, tweet.getRetweetCount());
		assertTrue(createdAt.equals(tweet.getCreatedAt()));
		assertTrue(place.equals(tweet.getPlace()));
		assertTrue(user.equals(tweet.getUser()));
		assertTrue(coordinates.equals(tweet.getCoordinates()));
	}
	
	@Override
	public void testInsert() {
		tweetDao.insert(tweet);
		assertEquals(1, tweetDao.count());
		
		Tweet postTweet = (Tweet) tweetDao.select(tweet.getId());
		
		assertTrue(postTweet.getText().equals(tweet.getText()));
		assertTrue(postTweet.getGeo().equals(tweet.getGeo()));
		assertTrue(postTweet.isTruncated() == tweet.isTruncated());
		assertEquals(postTweet.getTwitterId(), tweet.getTwitterId());
		assertTrue(postTweet.getSourceType().equals(tweet.getSourceType()));
		assertTrue(postTweet.isFavorited() == tweet.isFavorited());
		assertEquals(postTweet.getInReplyToTweetTwitterId(), tweet.getInReplyToTweetTwitterId());
		assertEquals(postTweet.getInReplyToUserTwitterId(), tweet.getInReplyToUserTwitterId());
		assertEquals(postTweet.getRetweetCount(), tweet.getRetweetCount());
		assertTrue(postTweet.getCreatedAt().equals(tweet.getCreatedAt()));
		assertTrue(postTweet.getPlace().equals(tweet.getPlace()));
		assertTrue(postTweet.getUser().equals(tweet.getUser()));
		assertTrue(postTweet.getCoordinates().equals(tweet.getCoordinates()));
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
		tweetDao.insert(tweet);
		assertEquals(1, tweetDao.count());
		tweetDao.delete(tweet);
		assertEquals(0, tweetDao.count());
	}

}
