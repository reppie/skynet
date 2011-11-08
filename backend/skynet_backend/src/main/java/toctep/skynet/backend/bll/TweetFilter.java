package toctep.skynet.backend.bll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TweetFilter {
	
	private TweetFilter() { }
	
	private static String[] commonWords = { " de ", " het ", " een " };
	private static final Pattern MENTION_OR_HASHTAG_REGEX = Pattern.compile("(^([#@]){1})([\\w]+)");
	private static final Pattern START_SPECIAL_CHAR_REGEX = Pattern.compile("^[^\\w]+");
	private static final Pattern END_SPECIAL_CHAR_REGEX = Pattern.compile("[^\\w]+$");
	private static Matcher matcher;
	
	public static ArrayList<String> filterTweet(ArrayList<String> unfilteredWords) {
		filterCommonWords(unfilteredWords);
		filterSpecialCharacters(unfilteredWords);
		
		return unfilteredWords;
	}
	
	public static void filterCommonWords(ArrayList<String> unfilteredWords) {
		for(int i = 0; i < unfilteredWords.size(); i++) {
			for(int j = 0; j < commonWords.length; j++) {
				if(unfilteredWords.get(i).equalsIgnoreCase(commonWords[j])) {
					unfilteredWords.remove(i);
				}
			}
		}
	}
	
	public static void filterSpecialCharacters(ArrayList<String> unfilteredWords) {
		for(int i = 0; i < unfilteredWords.size(); i++) {
			replaceIllegalStartingCharacters(unfilteredWords, i);
			replaceIllegalEndingCharacters(unfilteredWords, i);
			if(unfilteredWords.get(i).length() <= 1) {
				unfilteredWords.set(i, null);
			}
		}
		
		unfilteredWords.removeAll(Collections.singleton(null));
	}

	private static void replaceIllegalEndingCharacters(ArrayList<String> filteredWords, int i) {
		matcher = END_SPECIAL_CHAR_REGEX.matcher(filteredWords.get(i));
		filteredWords.set(i, matcher.replaceAll(""));
	}

	private static void replaceIllegalStartingCharacters(ArrayList<String> filteredWords, int i) {
		filteredWords.set(i, filteredWords.get(i).trim());
		matcher = MENTION_OR_HASHTAG_REGEX.matcher(filteredWords.get(i));
		if(!matcher.find()) {
			matcher = START_SPECIAL_CHAR_REGEX.matcher(filteredWords.get(i));
			filteredWords.set(i, matcher.replaceAll(""));
		}
	}

}
