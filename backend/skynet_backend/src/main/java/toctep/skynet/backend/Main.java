package toctep.skynet.backend;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import toctep.skynet.backend.dal.domain.user.User;

public class Main {

	public static final String DB_PROPERTIES = "mysql.properties";
	public static final String LOG_PROPERTIES = "log4j.properties";
	
	static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure(LOG_PROPERTIES);
				
		//new Thread(new TweetRetriever()).start();
		
		User t = new User();
		t.setId(0L);
		t.save();
	}

}
