package toctep.skynet.backend.bll;

public class TweetFilter {
	private String[] commonWords = { "de", "het", "een" };
	private String specialCharRegex = "[^@\\wa-zA-Z#\\w\\s]";
	private String singleCharRegex = "\\s[\\w]\\s";
	private String doubleSpaceRegex = "\\s+";
	
	
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
