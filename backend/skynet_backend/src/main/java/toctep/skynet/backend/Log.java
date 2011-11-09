package toctep.skynet.backend;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class Log {

	private static Logger LOG = Logger.getLogger(Skynet.class);
	
	private static boolean initialized = false;
	
	public static void initialize() {
		PropertyConfigurator.configure(Constants.LOG4J_CONFIG);
		initialized = true;
	}
	
	public static void debug (Object message) {
		if (!initialized)
			throw new RuntimeException("Logger has not been initialized");
			
		LOG.debug(message);
	}
	
	public static void error(Object message, Throwable t) {
		if (!initialized)
			throw new RuntimeException("Logger has not been initialized");
			
		LOG.error(message, t);
	}

}
