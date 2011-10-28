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
		tweetContributor.setUser_twitter_id(userTwitterId);
		assertEquals("getTweet: ", tweet, tweetContributor.getTweet());
		assertEquals("getUserTwitterId: ", userTwitterId, tweetContributor.getUser_twitter_id());
	}

	@Override
	public void testInsert() {
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
