package toctep.skynet.backend.test.dal;

import static org.junit.Assert.*;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetContributorTest extends DomainTest {

	private TweetContributor tweetContributor;
	
	private User user;
	private Tweet tweet;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetContributor = new TweetContributor();
		
		user = new User();
		user.setId(new Long(2));
		tweetContributor.setUser(user);
		
		tweet = new Tweet();
		tweet.setId(new Long(2));
		tweetContributor.setTweet(tweet);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(tweetContributor);
		assertEquals("getTweet: ", tweet, tweetContributor.getTweet());
		assertEquals("getUserTwitterId: ", user, tweetContributor.getUser());
	}

	@Override
	public void testInsert() {
		tweetContributor.save();
		assertEquals(1, tweetContributorDao.count());
	}
	
	@Override
	public void testSelect() {
		tweetContributor.save();
		
		TweetContributor postTweetContributor = TweetContributor.select(tweetContributor.getId());
		
		assertTrue(postTweetContributor.getTweet().getId().equals(tweetContributor.getTweet().getId()));
		assertTrue(postTweetContributor.getUser().getId().equals(tweetContributor.getUser().getId()));		
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		User user = new User();
		user.setId(new Long(1));
		
		tweet.addContributor(user);
		
		tweet.save();
		
		assertEquals(1, tweet.getContributors().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getContributors().size());
	}

	@Override
	public void testDelete() {
		tweetContributor.save();
		assertEquals(1, tweetContributorDao.count());
		tweetContributor.delete();
		assertEquals(0, tweetContributorDao.count());
	}

	@Override
	public void testExists() {
		tweetContributor.save();
		assertTrue(tweetContributorDao.exists(tweetContributor));
	}
	
}
