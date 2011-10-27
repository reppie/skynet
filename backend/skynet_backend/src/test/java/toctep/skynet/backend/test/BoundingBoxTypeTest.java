package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.BoundingBox;
import toctep.skynet.backend.dal.domain.BoundingBoxType;

public class BoundingBoxTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		assertNotNull(boundingBoxType);
		
		String text = "Point";
		boundingBoxType.setText(text);
		assertTrue(text.equals(boundingBoxType.getText()));
	}

	@Override
	public void testDelete() {
		BoundingBox boundingBox = new BoundingBox();
		assertNotNull(boundingBox);
		boundingBoxDao.insert(boundingBox);
		assertEquals(1, boundingBoxDao.count());
		boundingBoxDao.delete(boundingBox);
		assertEquals(0, boundingBoxDao.count());		
	}

	@Override
	public void testInsert() {
		BoundingBoxType preBoundingBoxType = new BoundingBoxType();
		
		String text = "Point";
		preBoundingBoxType.setText(text);
		
		boundingBoxTypeDao.insert(preBoundingBoxType);
		assertEquals(1, boundingBoxTypeDao.count());
		
		BoundingBoxType postBoundingBoxType = (BoundingBoxType) boundingBoxTypeDao.select(preBoundingBoxType.getId());
		assertTrue(postBoundingBoxType.getText().equals(preBoundingBoxType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
