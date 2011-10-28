package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetContributor;

public class TweetContributorTest extends DomainTest {

	@Override
	public void testCreate() {
		TweetContributor tweetContributor = new TweetContributor();
		assertNotNull(tweetContributor);
		
		long userTwitterId = 123456789;
		Tweet tweet = new Tweet();
		tweetContributor.setTweet(tweet);
		tweetContributor.setUserTwitterId(userTwitterId);
		
		assertEquals("getTweet: ", tweet, tweetContributor.getTweet());
		assertEquals("getUserTwitterId: ", userTwitterId, tweetContributor.getUserTwitterId());
	}

	@Override
	public void testInsert() {
		TweetContributor preTweetContributor = new TweetContributor();
		
		Tweet tweet = new Tweet();
		preTweetContributor.setTweet(tweet);
		
		long userTwitterId = 0L;
		preTweetContributor.setUserTwitterId(userTwitterId);
		
		tweetContributorDao.insert(preTweetContributor);
		assertEquals(1, tweetContributorDao.count());
		
		TweetContributor postTweetContributor = (TweetContributor) tweetContributorDao.select(preTweetContributor.getId());
		
		assertEquals(postTweetContributor.getUserTwitterId(), preTweetContributor.getUserTwitterId());
		assertTrue(postTweetContributor.getTweet().equals(preTweetContributor.getTweet()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		TweetContributor tweetContributor = new TweetContributor();
		assertNotNull(tweetContributor);
		tweetContributorDao.insert(tweetContributor);
		assertEquals(1, tweetContributorDao.count());
		tweetContributorDao.delete(tweetContributor);
		assertEquals(0, tweetContributorDao.count());
	}
	
	

}
