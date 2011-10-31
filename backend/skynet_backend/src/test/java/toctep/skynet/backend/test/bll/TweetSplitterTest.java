package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toctep.skynet.backend.bll.TweetSplitter;

public class TweetSplitterTest {
	
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
		
		tweetWordsAfterSplit = TweetSplitter.splitTweet(tweetBody);
		
		for(int i = 0; i < presplitTweetBody.length; i++) {
			assertEquals("result: ", presplitTweetBody[i], tweetWordsAfterSplit[i]);
		}
	}

}
