package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.SourceType;

public class SourceTypeTest extends DomainTest {

	private SourceType sourceType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		sourceType = new SourceType();
		
		text = "Web";
		sourceType.setText(text);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(sourceType);
		assertTrue(text.equals(sourceType.getText()));
	}

	@Override
	public void testInsert() {
		sourceTypeDao.insert(sourceType);
		assertEquals(1, sourceTypeDao.count());
		assertEquals(1, sourceType.getId());
	}
	
	@Override
	public void testSelect() {
		sourceTypeDao.insert(sourceType);
		
		SourceType postSourceType = (SourceType) sourceTypeDao.select(sourceType.getId());
		
		assertTrue(postSourceType.getText().equals(sourceType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		sourceTypeDao.insert(sourceType);
		assertEquals(1, sourceTypeDao.count());
		sourceTypeDao.delete(sourceType);
		assertEquals(0, sourceTypeDao.count());
	}
	
}
