package toctep.skynet.backend.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetFilter {
	private String[] commonWords = { "de", "het", "een" };
	private static final Pattern SPECIAL_CHAR_REGEX = Pattern.compile("[^@\\wa-zA-Z#\\w\\s]");
	private static final Pattern SINGLE_CHAR_REGEX = Pattern.compile("\\s[\\w]\\s");
	private static final Pattern MULTIPLE_SPACE_REGEX = Pattern.compile("\\s+");
	private Matcher matcher;
	
	
	public String filterCommonWords(String tweetText) {
		String cleanTweet = tweetText;
		
		for(String commonWord: commonWords) {
			if(cleanTweet.contains(commonWord)) {
				cleanTweet = cleanTweet.replaceAll(commonWord, "");
			}
		}
		cleanTweet = removeMultipleSpaces(cleanTweet);
		
		return cleanTweet;
	}
	
	private String removeMultipleSpaces(String dirtyString) {
		matcher = MULTIPLE_SPACE_REGEX.matcher(dirtyString);
		return matcher.replaceAll(" ").trim();
	}
	
	public String filterSpecialCharacters(String tweetText) {
		matcher = SPECIAL_CHAR_REGEX.matcher(tweetText);
		String cleanTweet = matcher.replaceAll("");
		cleanTweet = removeMultipleSpaces(cleanTweet);
		cleanTweet = filterSingleCharacter(cleanTweet);
		
		return cleanTweet;
	}
	
	private String filterSingleCharacter(String dirtyString) {
		matcher = SINGLE_CHAR_REGEX.matcher(dirtyString);
		return matcher.replaceAll(" ");
	}

}
