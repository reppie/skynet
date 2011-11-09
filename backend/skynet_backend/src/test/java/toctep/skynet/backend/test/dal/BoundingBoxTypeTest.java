package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBoxType;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBoxType;
import toctep.skynet.backend.test.SkynetTest;

public class BoundingBoxTypeTest extends SkynetTest implements IDomainTest {

	private BoundingBoxType boundingBoxType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		boundingBoxType = new BoundingBoxType();
		
		text = "Point";
		boundingBoxType.setText(text);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(boundingBoxType);
		assertTrue(text.equals(boundingBoxType.getText()));
	}
	
	@Test
	public void testInsert() {
		boundingBoxType.save();
		assertEquals(1, BoundingBoxType.count());
		assertTrue(new Integer(1).equals(boundingBoxType.getId()));
	}
	
	@Test
	public void testSelect() {
		boundingBoxType.save();
		
		IBoundingBoxType postBoundingBoxType = BoundingBoxType.select(boundingBoxType.getId());
		assertTrue(postBoundingBoxType.getText().equals(boundingBoxType.getText()));
		
		IBoundingBoxType nullBoundingBoxType = BoundingBoxType.select(1000);
		assertTrue(nullBoundingBoxType instanceof NullBoundingBoxType);
	}
	
	@Test
	public void testDelete() {
		boundingBoxType.save();
		assertEquals(1, BoundingBoxType.count());
		boundingBoxType.delete();
		assertEquals(0, BoundingBoxType.count());		
	}

	@Test
	public void testExists() {
		boundingBoxType.save();
		assertTrue(BoundingBoxType.exists(boundingBoxType));
	}
	
}
