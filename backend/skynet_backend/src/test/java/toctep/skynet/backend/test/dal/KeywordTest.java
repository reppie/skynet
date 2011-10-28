package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Keyword;

public class KeywordTest extends DomainTest {
	private Keyword keyword;
	private int keywordId;
	private String keywordValue;

	@Override
	public void setUp() {
		super.setUp();
		
		keyword = new Keyword();
		int keywordId = 112;
		String keywordValue = "cvketel";
		
		keyword.setKeywordId(keywordId);
		keyword.setKeyword(keywordValue);
	}
	@Override
	public void testCreate() {
		assertNotNull(keyword);
		
		assertEquals("getKeywordId: ", keywordId, keyword.getKeywordId());
		assertEquals("getKeyword: ", keywordValue, keyword.getKeyword());
	}

	@Override
	public void testInsert() {
		keywordDao.insert(keyword);
		
		Keyword postKeyword = (Keyword) keywordDao.select(keyword.getId());
		assertEquals("getKeywordId: ", keyword.getKeywordId(), postKeyword.getKeywordId());
		assertEquals("getKeyword: ", keyword.getKeyword(), postKeyword.getKeyword());
	}

	@Override
	public void testSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub
		
	}

}
