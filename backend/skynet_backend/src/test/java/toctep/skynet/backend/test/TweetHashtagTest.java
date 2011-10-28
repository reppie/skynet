package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Hashtag;
import toctep.skynet.backend.dal.domain.Tweet;
import toctep.skynet.backend.dal.domain.TweetHashtag;

public class TweetHashtagTest extends DomainTest {

	@Override
	public void testCreate() {
		TweetHashtag tweetHashtag = new TweetHashtag();
		assertNotNull(tweetHashtag);
		
		Tweet tweet = new Tweet();
		Hashtag hashtag = new Hashtag();
		tweetHashtag.setHashtag(hashtag);
		tweetHashtag.setTweet(tweet);
		assertEquals("getHashtag: ", hashtag, tweetHashtag.getHashtag());
		assertEquals("getTweet: ", tweet, tweetHashtag.getTweet());
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
