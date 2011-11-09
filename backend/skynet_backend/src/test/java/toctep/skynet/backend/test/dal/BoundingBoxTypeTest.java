package toctep.skynet.backend.test.dal;

import static org.junit.Assert.*;

import toctep.skynet.backend.dal.domain.boundingbox.BoundingBoxType;

public class BoundingBoxTypeTest extends DomainTest {

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
		boundingBoxType.save();
		assertEquals(1, boundingBoxTypeDao.count());
		assertTrue(new Integer(1).equals(boundingBoxType.getId()));
	}
	
	@Override
	public void testSelect() {
		boundingBoxType.save();
		
		BoundingBoxType postBoundingBoxType = (BoundingBoxType) boundingBoxTypeDao.select(boundingBoxType.getId());
		
		assertTrue(postBoundingBoxType.getText().equals(boundingBoxType.getText()));
	}
	
	@Override
	public void testDelete() {
		boundingBoxType.save();
		assertEquals(1, boundingBoxTypeDao.count());
		boundingBoxType.delete();
		assertEquals(0, boundingBoxTypeDao.count());		
	}

	@Override
	public void testExists() {
		boundingBoxType.save();
		assertTrue(boundingBoxTypeDao.exists(boundingBoxType));
	}
	
}
