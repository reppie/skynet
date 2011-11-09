package toctep.skynet.backend.bll;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import toctep.skynet.backend.log.Log;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public final class TweetUtils {
	
	private TweetUtils() {}
	
	public static final String LANGDETECT_PROFILE_DIR = "lib/langdetect/profiles";
	private static boolean langdetectInitialized = false;
	private static Calendar c = Calendar.getInstance();
	
	
	public static synchronized Timestamp createUTCTimeStamp(Date date){
		c.setTime(date);
		return new Timestamp((long)(c.getTime().getTime()-c.getTimeZone().getRawOffset()));
	}
	
	
	private static void initialize() {
		try {
			DetectorFactory.loadProfile(LANGDETECT_PROFILE_DIR);
			langdetectInitialized = true;
		} catch (LangDetectException e) {
			Log.error(e.getMessage(), e);
		}
	}
	
	public static boolean isDutchLocation(String userLocation) {
		List<String> locations = new ArrayList<String>();
		locations.add("netherland");
		locations.add("netherlands");
		locations.add("nederland");
		locations.add("holland");
		
		if (locations.contains(userLocation.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public static boolean isDutchLanguage(String text, String userLanguage) {
		if(!langdetectInitialized) {
			initialize();
		}
		
		Detector detector = null;
		String lang = null;
		
		try {
			detector = DetectorFactory.create();
			detector.append(text);

			lang = detector.detect();
		} catch (LangDetectException e) {
			Log.error(e.getMessage(), e);
		}		
		
		if (userLanguage.equalsIgnoreCase("nl")) {
			return true;
		}
		if(lang.equalsIgnoreCase("nl")) {
			return true;
		}
		return false;
	}
	
	public static boolean isDutchTimeZone(String timezone) {
		if (timezone.equalsIgnoreCase("amsterdam")) {
			return true;
		}
		return false;
	}	
}
