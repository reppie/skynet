package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import toctep.skynet.backend.bll.TweetFilter;

public class TweetFilterTest {
	
	@Test
	public void filterCommonWordsTest() {
		List<String> rawTweet = new ArrayList<String>(); 
		rawTweet.add("slimme");
		rawTweet.add("vos");
		rawTweet.add("uit");
		rawTweet.add(" het ");
		rawTweet.add("bos,");
		rawTweet.add("springt  ");
		rawTweet.add("over");
		rawTweet.add(" een ");
		rawTweet.add("hoog");
		rawTweet.add("hek");
		
		List<String> cleanTweet = new ArrayList<String>(); 
		cleanTweet.add("slimme");
		cleanTweet.add("vos");
		cleanTweet.add("uit");
		cleanTweet.add("bos");
		cleanTweet.add("springt");
		cleanTweet.add("over");
		cleanTweet.add("hoog");
		cleanTweet.add("hek");
	
		List<String> filteredTweet = TweetFilter.filterTweet(rawTweet);
		assertEquals("list size: ", cleanTweet.size(), filteredTweet.size());
		
		for(int i = 0; i < cleanTweet.size(); i++) {
			assertEquals("word compare: ", cleanTweet.get(i), filteredTweet.get(i));
		}
	}
	
	@Test
	public void filterSpecialCharactersTest() {
		List<String> rawTweet = new ArrayList<String>();
		rawTweet.add("@georgeBaker");
		rawTweet.add("@SjorsBakker");
		rawTweet.add("little");
		rawTweet.add("green        ");
		rawTweet.add("bag");
		rawTweet.add("is");
		rawTweet.add("zo");
		rawTweet.add("        leuk!!");
		rawTweet.add("&");
		rawTweet.add("energiek,          ");
		rawTweet.add("echt");
		rawTweet.add("                                 @$$g/ewel[ig");
		rawTweet.add("+1!!");
		rawTweet.add("#burn!!");
		rawTweet.add("#7even");
		rawTweet.add("#Herp^");
		
		List<String> cleanTweet = new ArrayList<String>();
		cleanTweet.add("@georgeBaker");
		cleanTweet.add("@SjorsBakker");
		cleanTweet.add("little");
		cleanTweet.add("green");
		cleanTweet.add("bag");
		cleanTweet.add("is");
		cleanTweet.add("zo");
		cleanTweet.add("leuk");
		cleanTweet.add("energiek");
		cleanTweet.add("echt");
		cleanTweet.add("g/ewel[ig");
		cleanTweet.add("#burn");
		cleanTweet.add("#7even");
		cleanTweet.add("#Herp");
		
		List<String> filteredTweets = TweetFilter.filterTweet(rawTweet);
		assertEquals("List size: ", cleanTweet.size(), filteredTweets.size());
		
		for(int i = 0; i < cleanTweet.size(); i++) {
			assertEquals("list contents: ", cleanTweet.get(i), filteredTweets.get(i));
		}
	}

}
