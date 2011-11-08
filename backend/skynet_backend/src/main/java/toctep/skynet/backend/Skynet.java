package toctep.skynet.backend;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import toctep.skynet.backend.bll.GeoTaggedTweetRetriever;

public final class Skynet {

	private Skynet() { }
	
	public static final String DB_CONFIG = "mysql.properties";
	public static final String DB_TEST_CONFIG = "mysql_test.properties";
	public static final String LOG4J_CONFIG = "log4j.properties";
	public static final String TWITTER4J_CONFIG = "twitter4j.properties";
	
	public static final Logger LOG = Logger.getLogger(Skynet.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure(LOG4J_CONFIG);
		
		new Thread(new GeoTaggedTweetRetriever()).start();
	}

}
