package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;
import toctep.skynet.backend.dal.domain.user.User;
import toctep.skynet.backend.test.SkynetTest;

public class TweetMentionTest extends SkynetTest implements IDomainTest {

	private TweetMention tweetMention;
	
	private User user;
	private Tweet tweet;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetMention = new TweetMention();
		
		user = new User();
		user.setId(new Long(1));
		tweetMention.setUser(user);
		
		tweet = new Tweet();
		tweet.setId(new Long(1));
		tweetMention.setTweet(tweet);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(tweetMention);
		assertEquals("getTweet: ", tweet, tweetMention.getTweet());
		assertEquals("getUser: ", user, tweetMention.getUser());
	}

	@Test
	public void testInsert() {
		tweetMention.save();
		assertEquals(1, TweetMention.count());
	}
	
	@Test
	public void testSelect() {
		tweetMention.save();

		TweetMention postTweetMention = TweetMention.select(tweetMention.getId());

		assertTrue(postTweetMention.getTweet().getId().equals(tweetMention.getTweet().getId()));
		assertTrue(postTweetMention.getUser().getId().equals(tweetMention.getUser().getId()));	
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		User user = new User();
		user.setId(new Long(1));
		user.save();
		
		tweet.addMention(user);
		
		tweet.save();
		
		assertEquals(1, tweet.getMentions().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getMentions().size());
	}
	
	@Test
	public void testSelectFromTweetWithNullUser() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		User user = new User();
		user.setId(new Long(1));
		
		tweet.addMention(user);
		
		tweet.save();
		
		assertEquals(1, tweet.getMentions().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getMentions().size());
	}

	@Test
	public void testDelete() {
		tweetMention.save();
		assertEquals(1, TweetMention.count());
		tweetMention.delete();
		assertEquals(0, TweetMention.count());
	}

	@Test
	public void testExists() {
		tweetMention.save();
		assertTrue(TweetMention.exists(tweetMention));
		assertTrue(TweetMention.exists(tweetMention.getId()));
	}
	
}
