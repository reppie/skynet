package toctep.skynet.backend.test;

import junit.framework.TestCase;

import org.junit.Test;

import toctep.skynet.backend.log.Log;
import toctep.skynet.backend.log.LogException;

public class LogTest extends TestCase {

	@Test
	public void testInitialize() {
		Log.initialize();
		Log.debug("test");
	}
	
	@Test(expected=LogException.class)
	public void testLogException() {
		Log.debug("test");
	}
	
}
