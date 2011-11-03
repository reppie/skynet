package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBoxType;

public class BoundingBoxTest extends DomainTest{

	private BoundingBox boundingBox;
	
	private IBoundingBoxType boundingBoxType;
	private String coordinates;
	
	@Override
	public void setUp() {
		super.setUp();
		
		boundingBox = new BoundingBox();
		
		boundingBoxType = new BoundingBoxType();
		boundingBox.setType(boundingBoxType);
		
		coordinates = "58.17, 68.20";
		boundingBox.setCoordinates(coordinates);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(boundingBox);
		assertTrue(boundingBox.getType().equals(boundingBoxType));
		assertTrue(coordinates.equals(boundingBox.getCoordinates()));
	}

	@Override
	public void testInsert() {	
		boundingBox.save();
		assertEquals(1, boundingBoxDao.count());
		assertTrue(new Integer(1).equals(boundingBox.getId()));
	}

	@Override
	public void testSelect() {
		boundingBox.save();
		
		BoundingBox postBoundingBox = (BoundingBox) boundingBoxDao.select(boundingBox.getId());
		
		assertTrue(postBoundingBox.getType().getId().equals(boundingBox.getType().getId()));
		assertTrue(postBoundingBox.getCoordinates().equals(boundingBox.getCoordinates()));
	}
	
	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		boundingBox.save();
		assertEquals(1, boundingBoxDao.count());
		boundingBox.delete();
		assertEquals(0, boundingBoxDao.count());		
	}

	@Override
	public void testExists() {
		boundingBox.save();
		assertTrue(boundingBoxDao.exists(boundingBox));
	}
	
}
