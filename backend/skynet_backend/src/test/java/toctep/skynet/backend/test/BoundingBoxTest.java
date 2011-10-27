package toctep.skynet.backend.test;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
