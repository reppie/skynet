package toctep.skynet.backend.test.dal;

import java.sql.Types;

import junit.framework.TestCase;

import org.junit.Test;

import toctep.skynet.backend.dal.dao.impl.mysql.MySqlUtil;
import toctep.skynet.backend.dal.dao.impl.mysql.Param;

public class MysqlUtilTest extends TestCase {
	
	@Test
	public void testGetGeneratedId() {
		MySqlUtil mysql = MySqlUtil.getInstance();
		mysql.truncateDatabase();
		
		Long id = mysql.insert(
			"INSERT INTO twitter_keyword(keyword) VALUES(?)", 
			new Param[]{new Param("keyword1", Types.VARCHAR)}
		);
		assertTrue("ID: ", new Long(1).equals(id));
		
		id = mysql.insert(
			"INSERT INTO twitter_keyword(keyword) VALUES(?)",
			new Param[]{new Param("keyword2", Types.VARCHAR)}
		);
		assertTrue("ID: ", new Long(2).equals(id));
	}
	
}