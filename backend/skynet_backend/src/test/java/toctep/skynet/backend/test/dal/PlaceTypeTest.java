package toctep.skynet.backend.test.dal;

import static org.junit.Assert.*;

import toctep.skynet.backend.dal.domain.place.PlaceType;

public class PlaceTypeTest extends DomainTest {

	private PlaceType placeType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		placeType = new PlaceType();
		
		text = "City";
		placeType.setText(text);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(placeType);
		assertTrue(text.equals(placeType.getText()));
	}
	
	@Override
	public void testInsert() {
		placeType.save();
		assertEquals(1, placeTypeDao.count());
		assertTrue(new Integer(1).equals(placeType.getId()));
	}
	
	@Override
	public void testSelect() {
		placeType.save();
		
		PlaceType postPlaceType = (PlaceType) placeTypeDao.select(placeType.getId());
		
		assertTrue(postPlaceType.getText().equals(placeType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		placeType.save();
		assertEquals(1, placeTypeDao.count());
		placeType.delete();
		assertEquals(0, placeTypeDao.count());
	}

	@Override
	public void testExists() {
		placeType.save();
		assertTrue(placeTypeDao.exists(placeType));
	}
	
}
