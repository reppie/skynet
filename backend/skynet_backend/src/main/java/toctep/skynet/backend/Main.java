package toctep.skynet.backend;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import toctep.skynet.backend.bll.TweetRetriever;

public class Main {

	static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
				
		new Thread(new TweetRetriever()).start();
	}

}
