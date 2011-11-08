package toctep.skynet.backend.bll;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TweetUtils {
	
	public synchronized static Timestamp createUTCTimeStamp(Date date){
		c.setTime(date);
		Timestamp ts = new Timestamp((long)(c.getTime().getTime()-c.getTimeZone().getRawOffset()));
		return ts;
	}

	private TweetUtils() {}
	
	private static Calendar c = Calendar.getInstance();
}
