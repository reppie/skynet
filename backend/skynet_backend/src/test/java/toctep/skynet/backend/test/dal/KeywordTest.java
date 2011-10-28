package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Keyword;

public class KeywordTest extends DomainTest {

	@Override
	public void testCreate() {
		Keyword keyword = new Keyword();
		assertNotNull(keyword);
		
		int keywordId = 112;
		String keywordValue = "cvketel";
		keyword.setKeywordId(keywordId);
		keyword.setKeyword(keywordValue);
		assertEquals("getKeywordId: ", keywordId, keyword.getKeywordId());
		assertEquals("getKeyword: ", keywordValue, keyword.getKeyword());
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
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
