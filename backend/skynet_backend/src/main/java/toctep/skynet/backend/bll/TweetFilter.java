package toctep.skynet.backend.bll;

import java.util.regex.Pattern;

public class TweetFilter {
	private String[] commonWords = { "de", "het", "een" };
	private static Pattern specialCharRegex = Pattern.compile("[^@\\wa-zA-Z#\\w\\s]");
	private static Pattern singleCharRegex = Pattern.compile("\\s[\\w]\\s");
	private static Pattern doubleSpaceRegex = Pattern.compile("\\s+");
	
	
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
		return dirtyString.replaceAll(doubleSpaceRegex, " ").trim();
	}
	
	public String filterSpecialCharacters(String tweetText) {
		String cleanTweet = tweetText.replaceAll(specialCharRegex, "");
		cleanTweet = removeMultipleSpaces(cleanTweet);
		cleanTweet = filterSingleCharacter(cleanTweet);
		
		return cleanTweet;
	}
	
	private String filterSingleCharacter(String dirtyString) {
		return dirtyString.replaceAll(singleCharRegex, " ");
	}

}
