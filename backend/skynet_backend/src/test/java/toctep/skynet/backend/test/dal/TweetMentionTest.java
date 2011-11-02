package toctep.skynet.backend.test.dal;

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
		
		TweetMention tweetMention = new TweetMention();
		
		User user = new User();
		tweetMention.setUser(user);
		
		Tweet tweet = new Tweet();
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
		
		assertTrue(postTweetMention.getTweet().equals(tweetMention.getTweet()));
		assertTrue(postTweetMention.getUser().equals(tweetMention.getUser()));	
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
