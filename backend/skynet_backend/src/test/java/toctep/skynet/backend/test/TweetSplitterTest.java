package toctep.skynet.backend.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import toctep.skynet.backend.bll.TweetSplitter;

public class TweetSplitterTest {
	private TweetSplitter tweetSplitter;
	
	@Before
	public void setUp() {
		tweetSplitter = new TweetSplitter();
	}
	
	@Test
	public void splitTweetTest() {
		String tweetBody = "@georgeBaker looking back on the track for a little green bag #muziek";
		String[] presplitTweetBody = { 
				"@georgeBaker", 
				"looking", 
				"back", 
				"on", 
				"the",
				"track", 
				"for",
				"a",
				"little",
				"green",
				"bag",
				"#muziek"
		};
		
		String[] tweetWordsAfterSplit = {};
		
		tweetWordsAfterSplit = tweetSplitter.splitTweet(tweetBody);
		
		for(int i = 0; i < presplitTweetBody.length; i++) {
			assertEquals("result: ", presplitTweetBody[i], tweetWordsAfterSplit[i]);
		}
	}

}
