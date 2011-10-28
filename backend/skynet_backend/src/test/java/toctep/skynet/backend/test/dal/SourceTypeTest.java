package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.SourceType;

public class SourceTypeTest extends DomainTest {

	@Override
	public void testCreate() { 
		SourceType sourceType = new SourceType();
		assertNotNull(sourceType);
		
		String text = "Web";
		sourceType.setText(text);
		
		assertTrue(text.equals(sourceType.getText()));
	}

	@Override
	public void testDelete() {
		SourceType sourceType = new SourceType();
		assertNotNull(sourceType);
		sourceTypeDao.insert(sourceType);
		assertEquals(1, sourceTypeDao.count());
		sourceTypeDao.delete(sourceType);
		assertEquals(0, sourceTypeDao.count());
	}

	@Override
	public void testInsert() {
		SourceType preSourceType = new SourceType();
		
		String text = "test";
		preSourceType.setText(text);
		
		sourceTypeDao.insert(preSourceType);
		assertEquals(1, sourceTypeDao.count());
		
		SourceType postSourceType = (SourceType) sourceTypeDao.select(preSourceType.getId());
		
		assertTrue(postSourceType.getText().equals(preSourceType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
