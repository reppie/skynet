package toctep.skynet.backend.test.dal;

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
		user.setId(new Long(1));
		tweetContributor.setUser(user);
		
		tweet = new Tweet();
		tweet.setId(new Long(1));
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
		
		TweetContributor postTweetContributor = (TweetContributor) tweetContributorDao.select(tweetContributor.getId());
		
		assertTrue(postTweetContributor.getTweet().getId().equals(tweetContributor.getTweet().getId()));
		assertTrue(postTweetContributor.getUser().getId().equals(tweetContributor.getUser().getId()));		
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
