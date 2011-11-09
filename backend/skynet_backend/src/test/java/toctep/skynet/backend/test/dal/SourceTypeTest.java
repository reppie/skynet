package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.sourcetype.SourceType;

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
		sourceType.save();
		assertEquals(1, sourceTypeDao.count());
		assertTrue(new Integer(1).equals(sourceType.getId()));
	}
	
	@Override
	public void testSelect() {
		sourceType.save();
		
		SourceType postSourceType = (SourceType) sourceTypeDao.select(sourceType.getId());
		
		assertTrue(postSourceType.getText().equals(sourceType.getText()));
	}
	
	@Override
	public void testDelete() {
		sourceType.save();
		assertEquals(1, sourceTypeDao.count());
		sourceType.delete();
		assertEquals(0, sourceTypeDao.count());
	}

	@Override
	public void testExists() {
		sourceType.save();
		assertTrue(sourceTypeDao.exists(sourceType));
	}
	
}
