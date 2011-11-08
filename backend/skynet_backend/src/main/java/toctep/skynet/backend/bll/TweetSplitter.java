package toctep.skynet.backend.bll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class TweetSplitter {
	
	private TweetSplitter() { }
	
	private static final Pattern SINGLE_SPACE_REGEX = Pattern.compile("\\s");
	
	public static List<String> splitTweet(String tweetBody) {
		return new ArrayList<String>(Arrays.asList(SINGLE_SPACE_REGEX.split(tweetBody)));
	}

}
