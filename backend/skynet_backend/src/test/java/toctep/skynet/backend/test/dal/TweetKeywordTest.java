package toctep.skynet.backend.test.dal;

import java.sql.Date;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.timezone.TimeZone;
import toctep.skynet.backend.dal.domain.tweet.Keyword;
import toctep.skynet.backend.dal.domain.tweet.SourceType;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;
import toctep.skynet.backend.dal.domain.url.Url;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetKeywordTest extends DomainTest {
	private TweetKeyword tweetKeyword;
	private Tweet tweet;
	private String keywordValue;
	private Keyword keyword;
	private Place place;
	private GeoType geoType;
	private Geo geo;
	private User user;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetKeyword = new TweetKeyword();
		
		tweet = new Tweet();
		geoType = new GeoType();
		geo = new Geo();
		geo.setType(geoType);
		tweet.setGeo(geo);

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
		tweet.setSourceType(new SourceType());
		tweet.setCreatedAt(new Date(0));
		
		keywordValue = "testValue";
		keyword = new Keyword();
		
		tweetKeyword.setKeyword(keyword);
		tweetKeyword.setTweet(tweet);
		tweetKeyword.setTweetKeywordValue(keywordValue);
	}

	@Override
	public void testCreate() {
		assertNotNull(tweetKeyword);
		
		assertEquals("getKeywordId: ", keyword, tweetKeyword.getKeyword());
		assertEquals("getKeywordValue: ", keywordValue, tweetKeyword.getTweetKeywordValue());
		assertEquals("getTweetId: ", tweet, tweetKeyword.getTweet());
	}

	@Override
	public void testInsert() {
		tweetKeyword.save();
		assertEquals(1, tweetKeywordDao.count());
	}

	@Override
	public void testSelect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub

	}

}
