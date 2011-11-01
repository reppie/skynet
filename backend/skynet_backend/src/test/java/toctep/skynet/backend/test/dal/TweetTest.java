package toctep.skynet.backend.test.dal;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Language;
import toctep.skynet.backend.dal.domain.SourceType;
import toctep.skynet.backend.dal.domain.TimeZone;
import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetTest extends DomainTest {

	private Tweet tweet;
	
	private long id;
	private String text;
	private Geo geo;
	private boolean truncated;
	private long twitterId;
	private SourceType sourceType;
	private boolean favorited;
	private Tweet inReplyToTweetTwitter;
	private User inReplyToUserTwitter;
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
		geo.setType(new GeoType());
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
		
		inReplyToUserTwitter = new User();
		inReplyToUserTwitter.setPlace(place);
		inReplyToUserTwitter.setLanguage(new Language());
		inReplyToUserTwitter.setUrl(new Url());
		inReplyToUserTwitter.setProfileBackgroundImageUrl(new Url());
		inReplyToUserTwitter.setProfileBackgroundImageUrlHttps(new Url());
		inReplyToUserTwitter.setProfileImageUrl(new Url());
		inReplyToUserTwitter.setProfileImageUrlHttps(new Url());
		inReplyToUserTwitter.setTimeZone(new TimeZone());
		inReplyToUserTwitter.setCreatedAt(new Date(0));
		tweet.setInReplyToUserTwitter(inReplyToUserTwitter);
		
		retweetCount = 0L;
		tweet.setRetweetCount(retweetCount);
		
		createdAt = new Date(0);
		tweet.setCreatedAt(createdAt);
				
		place = new Place();
		place.setType(new PlaceType());
		BoundingBox boundingBox = new BoundingBox();
		boundingBox.setType(new BoundingBoxType());
		place.setBoundingBox(boundingBox);
		place.setUrl(new Url());
		place.setCountry(new Country());
		tweet.setPlace(place);
		
		user = new User();
		user.setPlace(place);
		user.setLanguage(new Language());
		user.setUrl(new Url());
		user.setProfileBackgroundImageUrl(new Url());
		user.setProfileBackgroundImageUrlHttps(new Url());
		user.setProfileImageUrl(new Url());
		user.setProfileImageUrlHttps(new Url());
		user.setTimeZone(new TimeZone());
		user.setCreatedAt(new Date(0));
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
		tweet.save();
		assertEquals(1, tweetDao.count());
	}
	
	@Override
	public void testSelect() {
		tweet.save();
		
		Tweet postTweet = (Tweet) tweetDao.select(tweet.getId());
		
		assertTrue(postTweet.getText().equals(tweet.getText()));
		assertEquals(postTweet.getGeo().getId(), tweet.getGeo().getId());
		assertTrue(postTweet.isTruncated() == tweet.isTruncated());
		assertEquals(postTweet.getTwitterId(), tweet.getTwitterId());
		assertEquals(postTweet.getSourceType().getId(), tweet.getSourceType().getId());
		assertTrue(postTweet.isFavorited() == tweet.isFavorited());
		assertEquals(postTweet.getInReplyToTweetTwitterId(), tweet.getInReplyToTweetTwitterId());
		assertEquals(postTweet.getInReplyToUserTwitterId(), tweet.getInReplyToUserTwitterId());
		assertEquals(postTweet.getRetweetCount(), tweet.getRetweetCount());
		assertTrue(postTweet.getCreatedAt().equals(tweet.getCreatedAt()));
		assertTrue(postTweet.getPlace().getId().equals(tweet.getPlace().getId()));
		assertEquals(postTweet.getUser().getId(), tweet.getUser().getId());
		assertTrue(postTweet.getCoordinates().equals(tweet.getCoordinates()));
	}
	
	@Override
	public void testUpdate() {
		// TODO
	}
	
	@Override
	public void testDelete() {
		tweet.save();
		assertEquals(1, tweetDao.count());
		tweet.delete();
		assertEquals(0, tweetDao.count());
	}

}
