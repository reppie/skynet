package toctep.skynet.backend.bll;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public final class TweetUtils {
	
	private TweetUtils() {}
	
	public synchronized static Timestamp createUTCTimeStamp(Date date){
		c.setTime(date);
		return new Timestamp((long)(c.getTime().getTime()-c.getTimeZone().getRawOffset()));
	}

	
	private static Calendar c = Calendar.getInstance();
}
