package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.keyword.IKeyword;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.keyword.NullKeyword;

public class KeywordTest extends DomainTest {
	
	private Keyword keyword;
	private String keywordValue;

	@Override
	public void setUp() {
		super.setUp();
		
		keyword = new Keyword();
		keywordValue = "cvketel";
		
		keyword.setKeyword(keywordValue);
	}
	@Override
	public void testCreate() {
		assertNotNull(keyword);
		
		assertEquals("getKeyword: ", keywordValue, keyword.getKeyword());
	}

	@Override
	public void testInsert() {
		keyword.save();
		
		IKeyword postKeyword = Keyword.select(keyword.getId());
		assertEquals("getKeyword: ", keyword.getKeyword(), postKeyword.getKeyword());
		
		IKeyword nullKeyword = Keyword.select(1000);
		assertTrue(nullKeyword instanceof NullKeyword);
	}

	@Override
	public void testSelect() {
		keyword.save();
		
		Keyword postKeyword = (Keyword) keywordDao.select(keyword.getId());
		
		assertTrue(postKeyword.getKeyword().equals(postKeyword.getKeyword()));
	}

	@Override
	public void testDelete() {
		keyword.save();
		assertEquals(1, keywordDao.count());
		keyword.delete();
		assertEquals(0, keywordDao.count());	
	}
	
	@Override
	public void testExists() {
		keyword.save();
		assertTrue(keywordDao.exists(keyword));
	}

}
