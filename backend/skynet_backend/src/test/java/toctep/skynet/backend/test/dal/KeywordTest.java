package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.keyword.IKeyword;
import toctep.skynet.backend.dal.domain.keyword.Keyword;
import toctep.skynet.backend.dal.domain.keyword.NullKeyword;
import toctep.skynet.backend.test.SkynetTest;

public class KeywordTest extends SkynetTest implements IDomainTest {
	
	private Keyword keyword;
	private String keywordValue;

	@Override
	public void setUp() {
		super.setUp();
		
		keyword = new Keyword();
		keywordValue = "cvketel";
		
		keyword.setKeyword(keywordValue);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(keyword);
		
		assertEquals("getKeyword: ", keywordValue, keyword.getKeyword());
	}

	@Test
	public void testInsert() {
		keyword.save();
		
		IKeyword postKeyword = Keyword.select(keyword.getId());
		assertEquals("getKeyword: ", keyword.getKeyword(), postKeyword.getKeyword());
		
		IKeyword nullKeyword = Keyword.select(1000);
		assertTrue(nullKeyword instanceof NullKeyword);
	}

	@Test
	public void testSelect() {
		keyword.save();
		
		Keyword postKeyword = (Keyword) Keyword.select(keyword.getId());
		
		assertTrue(postKeyword.getKeyword().equals(postKeyword.getKeyword()));
	}

	@Test
	public void testDelete() {
		keyword.save();
		assertEquals(1, Keyword.count());
		keyword.delete();
		assertEquals(0, Keyword.count());	
	}
	
	@Test
	public void testExists() {
		keyword.save();
		assertTrue(Keyword.exists(keyword));
	}

}
