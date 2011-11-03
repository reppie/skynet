package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toctep.skynet.backend.bll.TweetFilter;

public class TweetFilterTest {
	
	@Test
	public void filterCommonWordsTest() {
		String rawTweet = "slimme vos uit het bos, springt over een hoog hek";
		String cleanTweet = "slimme vos uit bos, springt over hoog hek";
		
		assertEquals("filter result: ", cleanTweet, TweetFilter.filterCommonWords(rawTweet));
	}
	
	@Test
	public void filterSpecialCharactersTest() {
		String rawTweet = "@georgeBaker @SjorsBakker little green bag  is zo leuk!! & energiek, echt g/ewel[ig +1!! #burn!! #7even #Herp^";
		String cleanTweet = "@georgeBaker @SjorsBakker little green bag is zo leuk energiek echt gewelig #burn #7even #Herp";
		
		assertEquals("filter result: ", cleanTweet, TweetFilter.filterSpecialCharacters(rawTweet));
	}

}
