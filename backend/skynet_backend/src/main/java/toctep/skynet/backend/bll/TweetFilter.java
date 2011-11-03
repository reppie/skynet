package toctep.skynet.backend.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import toctep.skynet.backend.dal.domain.tweet.Tweet;

public class TweetFilter {
	private static String[] commonWords = { " de ", " het ", " een " };
	private static final Pattern SPECIAL_CHAR_REGEX = Pattern.compile("[^@\\wa-zA-Z#\\w\\s]");
	private static final Pattern SINGLE_CHAR_REGEX = Pattern.compile("\\s[\\w]\\s");
	private static final Pattern MULTIPLE_SPACE_REGEX = Pattern.compile("\\s+");
	private static Matcher matcher;
	
	public static String filterTweet(Tweet tweet) {
		String filteredTweet = filterCommonWords(tweet.getText());
		filteredTweet = filterSpecialCharacters(filteredTweet);
		
		return filteredTweet;
	}
	
	public static String filterCommonWords(String tweetText) {
		String cleanTweet = tweetText;
		
		for(String commonWord: commonWords) {
			if(cleanTweet.contains(commonWord)) {
				cleanTweet = cleanTweet.replaceAll(commonWord, " ");
			}
		}
		cleanTweet = removeMultipleSpaces(cleanTweet);
		
		return cleanTweet;
	}
	
	private static String removeMultipleSpaces(String dirtyString) {
		matcher = MULTIPLE_SPACE_REGEX.matcher(dirtyString);
		return matcher.replaceAll(" ").trim();
	}
	
	public static String filterSpecialCharacters(String tweetText) {
		matcher = SPECIAL_CHAR_REGEX.matcher(tweetText);
		String cleanTweet = matcher.replaceAll("");
		cleanTweet = removeMultipleSpaces(cleanTweet);
		cleanTweet = filterSingleCharacter(cleanTweet);
		
		return cleanTweet;
	}
	
	private static String filterSingleCharacter(String dirtyString) {
		matcher = SINGLE_CHAR_REGEX.matcher(dirtyString);
		return matcher.replaceAll(" ");
	}

}
