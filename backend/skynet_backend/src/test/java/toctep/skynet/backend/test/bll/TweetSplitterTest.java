package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import toctep.skynet.backend.bll.TweetSplitter;

public class TweetSplitterTest {
	
	@Test
	public void splitTweetTest() {
		String tweetBody = "@georgeBaker looking back on the track for a little green bag #muziek";
		List<String> presplitTweetBody = new ArrayList<String>();
		presplitTweetBody.add("@georgeBaker"); 
		presplitTweetBody.add("looking"); 
		presplitTweetBody.add("back");	
		presplitTweetBody.add("on");	
		presplitTweetBody.add("the");
		presplitTweetBody.add("track");
		presplitTweetBody.add("for");
		presplitTweetBody.add("a");
		presplitTweetBody.add("little");
		presplitTweetBody.add("green");
		presplitTweetBody.add("bag");
		presplitTweetBody.add("#muziek");
		
		List<String> tweetWordsAfterSplit = new ArrayList<String>();
		
		tweetWordsAfterSplit = TweetSplitter.splitTweet(tweetBody);
		
		assertEquals("words size: ", presplitTweetBody.size(), tweetWordsAfterSplit.size());
		for(int i = 0; i < presplitTweetBody.size(); i++) {
			assertEquals(presplitTweetBody.get(i), tweetWordsAfterSplit.get(i));
		}
	}

}
