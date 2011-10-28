package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetMention;

public class TweetMentionTest extends DomainTest {

	private TweetMention tweetMention;
	
	private long userTwitterId;
	private Tweet tweet;
	
	@Override
	public void setUp() {
		super.setUp();
		
		TweetMention tweetMention = new TweetMention();
		
		long userTwitterId = 123456789;
		tweetMention.setUser(userTwitterId);
		
		Tweet tweet = new Tweet();
		tweetMention.setTweet(tweet);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(tweetMention);
		assertEquals("getTweet: ", tweet, tweetMention.getTweet());
		assertEquals("getUser: ", userTwitterId, tweetMention.getUser());
	}

	@Override
	public void testInsert() {
		tweetMention.save();
		assertEquals(1, tweetMentionDao.count());
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
		tweetMentionDao.insert(tweetMention);
		assertEquals(1, tweetMentionDao.count());
		tweetMentionDao.delete(tweetMention);
		assertEquals(0, tweetMentionDao.count());
	}
}
