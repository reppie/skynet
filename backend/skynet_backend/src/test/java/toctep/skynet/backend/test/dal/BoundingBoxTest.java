package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.BoundingBox;
import toctep.skynet.backend.dal.domain.BoundingBoxType;

public class BoundingBoxTest extends DomainTest{

	@Override
	public void testCreate() { 
		BoundingBox boundingBox = new BoundingBox();
		assertNotNull(boundingBox);
		
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		boundingBox.setType(boundingBoxType);
		assertTrue(boundingBox.getType() == boundingBoxType);
		
		String coordinates = "58.17, 68.20";
		boundingBox.setCoordinates(coordinates);
		assertTrue(coordinates.equals(boundingBox.getCoordinates()));
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
		BoundingBox preBoundingBox = new BoundingBox();
		
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		preBoundingBox.setType(boundingBoxType);
		
		String coordinates = "58.18, 20.11";
		preBoundingBox.setCoordinates(coordinates);
		
		boundingBoxDao.insert(preBoundingBox);
		assertEquals(1, boundingBoxDao.count());
		
		BoundingBox postBoundingBox = (BoundingBox) boundingBoxDao.select(preBoundingBox.getId());
		assertTrue(postBoundingBox.getType().equals(preBoundingBox.getType()));
		assertTrue(postBoundingBox.getCoordinates().equals(preBoundingBox.getCoordinates()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
