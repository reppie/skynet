package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import toctep.skynet.backend.bll.TweetIndexer;
import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.dao.impl.mysql.MySqlUtil;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.tweet.Tweet;
import toctep.skynet.backend.dal.domain.tweet.TweetKeyword;

public class TweetParserTest {
	
	private MySqlUtil mysql;
	
	private KeywordDao keywordDao;
	
	@Before
	public void setUp() {
		mysql = MySqlUtil.getInstance("mysql_test.properties");
		mysql.truncateDatabase();
		
		keywordDao = DaoFacadeImpl.getInstance().getKeywordDao();
	}
	
	@Test
	public void indexTweetKeywordsText() {
		TweetIndexer indexer = new TweetIndexer();
		Tweet tweet = new Tweet();
		
		tweet.setId(new Long(1001));
		tweet.setText("wilfried elfstedentocht jager braam grietje horse");
		
		assertEquals("keyword count: ", 0, MySqlUtil.getInstance("mysql_test.properties").count("twitter_keyword"));
		
		Keyword keyword = new Keyword();
		keyword.setKeyword("elfstedentocht");
		keyword.save();
		assertEquals("keyword count: ", 1, MySqlUtil.getInstance("mysql_test.properties").count("twitter_keyword"));
		assertTrue(keywordDao.exists(keyword));
		
		keyword = new Keyword();
		keyword.setKeyword("elfstedentocht");
		keyword.save();
		assertEquals("keyword count: ", 1, MySqlUtil.getInstance("mysql_test.properties").count("twitter_keyword"));
		
		keyword = new Keyword();
		keyword.setKeyword("elfSTEDENtocht");
		keyword.save();
		assertEquals("keyword count: ", 1, MySqlUtil.getInstance("mysql_test.properties").count("twitter_keyword"));
		
		keyword = new Keyword();
		keyword.setKeyword("wilfried");
		keyword.save();
		assertEquals("keyword count: ", 2, MySqlUtil.getInstance("mysql_test.properties").count("twitter_keyword"));
		
		List<TweetKeyword> kws = indexer.indexTweetKeywords(tweet);
		
		assertEquals("keyword count: ", 6, kws.size());			
	}
	
	@After
	public void tearDown() {
		mysql.truncateDatabase();
	}

}
