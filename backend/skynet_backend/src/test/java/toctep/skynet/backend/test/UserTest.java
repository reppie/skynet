package toctep.skynet.backend.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import toctep.skynet.backend.dal.dao.impl.jdbc.DaoConnectionImpl;

import com.mysql.jdbc.Connection;

public class UserTest {
	
	private Connection conn;
	
	@Before
	public void setUp() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			conn = DaoConnectionImpl.getInstance(
					"hsqldb",
					"localhost",
					"skynet_test",
					"sa",
					"")
				.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
