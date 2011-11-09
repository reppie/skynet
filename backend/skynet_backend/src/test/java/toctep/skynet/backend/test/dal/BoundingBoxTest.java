package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;

public class BoundingBoxTest extends DomainTest {

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
		
		IBoundingBox postBoundingBox = BoundingBox.select(boundingBox.getId());
		assertTrue(postBoundingBox.getType().getId().equals(boundingBox.getType().getId()));
		assertTrue(postBoundingBox.getCoordinates().equals(boundingBox.getCoordinates()));
		
		IBoundingBox nullBoundingBox = BoundingBox.select(1000);
		assertTrue(nullBoundingBox instanceof NullBoundingBox);
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
