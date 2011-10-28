package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.BoundingBoxType;

public class BoundingBoxTypeTest extends DomainTest{

	private BoundingBoxType boundingBoxType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		boundingBoxType = new BoundingBoxType();
		
		text = "Point";
		boundingBoxType.setText(text);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(boundingBoxType);
		assertTrue(text.equals(boundingBoxType.getText()));
	}
	
	@Override
	public void testInsert() {
		boundingBoxTypeDao.insert(boundingBoxType);
		assertEquals(1, boundingBoxTypeDao.count());
		assertEquals(1, boundingBoxType.getId());
	}
	
	@Override
	public void testSelect() {
		boundingBoxTypeDao.insert(boundingBoxType);
		
		BoundingBoxType postBoundingBoxType = (BoundingBoxType) boundingBoxTypeDao.select(boundingBoxType.getId());
		
		assertTrue(postBoundingBoxType.getText().equals(boundingBoxType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		boundingBoxTypeDao.insert(boundingBoxType);
		assertEquals(1, boundingBoxTypeDao.count());
		boundingBoxTypeDao.delete(boundingBoxType);
		assertEquals(0, boundingBoxTypeDao.count());		
	}
	
}
