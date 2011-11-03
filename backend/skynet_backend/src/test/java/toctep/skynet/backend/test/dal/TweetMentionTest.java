package toctep.skynet.backend.test.dal;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetMention;
import toctep.skynet.backend.dal.domain.user.User;

public class TweetMentionTest extends DomainTest {

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
	
	@Override
	public void testCreate() {
		assertNotNull(tweetMention);
		assertEquals("getTweet: ", tweet, tweetMention.getTweet());
		assertEquals("getUser: ", user, tweetMention.getUser());
	}

	@Override
	public void testInsert() {
		tweetMention.save();
		assertEquals(1, tweetMentionDao.count());
	}
	
	@Override
	public void testSelect() {
		tweetMention.save();
		
		TweetMention postTweetMention = (TweetMention) tweetMentionDao.select(tweetMention.getId());
		
		assertTrue(postTweetMention.getTweet().getId().equals(tweetMention.getTweet().getId()));
		assertTrue(postTweetMention.getUser().getId().equals(tweetMention.getUser().getId()));	
	}
	
	@Test
	public void testSelectFromTweet() {
		Tweet tweet = new Tweet();
		tweet.setId(new Long(1));
		
		User user = new User();
		user.setId(new Long(1));
		
		TweetMention tweetMention = new TweetMention();
		tweetMention.setTweet(tweet);
		tweetMention.setUser(user);
		
		tweet.addMention(tweetMention);
		
		tweet.save();
		
		assertEquals(1, tweet.getMentions().size());
		
		Tweet postTweet = (Tweet) Tweet.select(tweet.getId());
		assertEquals(1, postTweet.getMentions().size());
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		tweetMention.save();
		assertEquals(1, tweetMentionDao.count());
		tweetMention.delete();
		assertEquals(0, tweetMentionDao.count());
	}
	
}
