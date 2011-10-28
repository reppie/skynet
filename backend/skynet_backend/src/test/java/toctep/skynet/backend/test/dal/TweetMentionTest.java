package toctep.skynet.backend.test.dal;

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
		TweetMention preTweetMention = new TweetMention();
		
		long user = 123456789;
		Tweet tweet = new Tweet();
		preTweetMention.setUser(user);
		preTweetMention.setTweet(tweet);
		
		tweetMentionDao.insert(preTweetMention);
		assertEquals(1, tweetMentionDao.count());
		
		TweetMention postTweetMention = (TweetMention) tweetMentionDao.select(preTweetMention.getId());
		assertEquals(preTweetMention.getUser(), postTweetMention.getUser());
		assertEquals(preTweetMention.getTweet(), postTweetMention.getTweet());
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		TweetMention tweetMention = new TweetMention();
		assertNotNull(tweetMention);
		tweetMentionDao.insert(tweetMention);
		assertEquals(1, tweetMentionDao.count());
		tweetMentionDao.delete(tweetMention);
		assertEquals(0, tweetMentionDao.count());
	}
}
