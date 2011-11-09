package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.test.SkynetTest;

public class BoundingBoxTest extends SkynetTest implements DomainTest {

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
	
	@Test
	public void testCreate() {
		assertNotNull(boundingBox);
		assertTrue(boundingBox.getType().equals(boundingBoxType));
		assertTrue(coordinates.equals(boundingBox.getCoordinates()));
	}

	@Test
	public void testInsert() {	
		boundingBox.save();
		assertEquals(1, BoundingBox.count());
		assertTrue(new Integer(1).equals(boundingBox.getId()));
	}

	@Test
	public void testSelect() {
		boundingBox.save();
		
		IBoundingBox postBoundingBox = BoundingBox.select(boundingBox.getId());
		assertTrue(postBoundingBox.getType().getId().equals(boundingBox.getType().getId()));
		assertTrue(postBoundingBox.getCoordinates().equals(boundingBox.getCoordinates()));
		
		IBoundingBox nullBoundingBox = BoundingBox.select(1000);
		assertTrue(nullBoundingBox instanceof NullBoundingBox);
	}
	
	@Test
	public void testDelete() {
		boundingBox.save();
		assertEquals(1, BoundingBox.count());
		boundingBox.delete();
		assertEquals(0, BoundingBox.count());		
	}

	@Test
	public void testExists() {
		boundingBox.save();
		assertTrue(BoundingBox.exists(boundingBox));
	}
	
}
