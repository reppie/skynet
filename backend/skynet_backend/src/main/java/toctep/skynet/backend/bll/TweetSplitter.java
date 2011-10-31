package toctep.skynet.backend.bll;

import java.util.regex.Pattern;

public class TweetSplitter {
	private static final Pattern SINGLE_SPACE_REGEX = Pattern.compile("\\s");
	
	public static String[] splitTweet(String tweetBody) {
		return SINGLE_SPACE_REGEX.split(tweetBody);
	}

}
