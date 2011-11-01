package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetContributor;

public class TweetContributorTest extends DomainTest {

	private TweetContributor tweetContributor;
	
	private long userTwitterId;
	private Tweet tweet;
	
	@Override
	public void setUp() {
		super.setUp();
		
		tweetContributor = new TweetContributor();
		
		userTwitterId = 123456789;
		tweetContributor.setUserTwitterId(userTwitterId);
		
		tweet = new Tweet();
		tweetContributor.setTweet(tweet);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(tweetContributor);
		assertEquals("getTweet: ", tweet, tweetContributor.getTweet());
		assertEquals("getUserTwitterId: ", userTwitterId, tweetContributor.getUserTwitterId());
	}

	@Override
	public void testInsert() {
		tweetContributor.save();
		assertEquals(1, tweetContributorDao.count());
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
		tweetContributor.save();
		assertEquals(1, tweetContributorDao.count());
		tweetContributor.delete();
		assertEquals(0, tweetContributorDao.count());
	}
	
}
