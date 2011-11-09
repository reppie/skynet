package toctep.skynet.backend.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import toctep.skynet.backend.Constants;
import toctep.skynet.backend.Skynet;

public final class Log {

	private static Logger logger = Logger.getLogger(Skynet.class);
	
	private static boolean initialized = false;
	
	private Log() {}
	
	public static void initialize() {
		PropertyConfigurator.configure(Constants.LOG4J_CONFIG);
		
		initialized = true;
	}
	
	public static boolean checkInitialized() {
		if (!initialized) {
			throw new LogException("Not initialized");
		}
		
		return true;
	}
	
	public static void debug (Object message) {
		checkInitialized();
		
		logger.debug(message);
	}
	
	public static void error(Object message, Throwable t) {
		checkInitialized();
		
		logger.error(message, t);
	}

}
