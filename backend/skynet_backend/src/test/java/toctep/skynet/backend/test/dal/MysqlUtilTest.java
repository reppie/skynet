package toctep.skynet.backend.test.dal;

import org.junit.Test;

import toctep.skynet.backend.dal.dao.impl.mysql.MySqlUtil;

import junit.framework.TestCase;

public class MysqlUtilTest extends TestCase {
	
	@Test
	public void testGetGeneratedId() {
		MySqlUtil mysql = MySqlUtil.getInstance();
		mysql.truncateDatabase();
		int id = mysql.insert("INSERT INTO twitter_keyword (keyword) VALUES ('keyword1');");
		assertEquals("ID: ", 1, id);
		
		id = mysql.insert("INSERT INTO twitter_keyword (keyword) VALUES ('keyword2');");
		assertEquals("ID: ", 2, id);
	}
	
}