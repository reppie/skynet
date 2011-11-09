package toctep.skynet.backend.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import toctep.skynet.backend.Constants;
import toctep.skynet.backend.dal.dao.impl.mysql.MySqlUtil;
import toctep.skynet.backend.log.Log;

public class SkynetTest {
	
	private static MySqlUtil mysql;
	
	@BeforeClass
	public static void setUpOnce() {
		Log.initialize();
		
		mysql = MySqlUtil.getInstance(Constants.DB_TEST_CONFIG);
	}
	
	@Before
	public void setUp() {
		mysql.truncateDatabase();
	}
	
	@After
	public void tearDown() {
		mysql.truncateDatabase();
	}
	
}
