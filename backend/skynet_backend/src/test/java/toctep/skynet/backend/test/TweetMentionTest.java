package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetMention;

public class TweetMentionTest extends DomainTest {

	@Override
	public void testCreate() {
		TweetMention tweetMention = new TweetMention();
		assertNotNull(tweetMention);
		
		long user = 123456789;
		Tweet tweet = new Tweet();
		tweetMention.setTweet(tweet);
		tweetMention.setUser(user);
		assertEquals("getTweet: ", tweet, tweetMention.getTweet());
		assertEquals("getUser: ", user, tweetMention.getUser());
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
