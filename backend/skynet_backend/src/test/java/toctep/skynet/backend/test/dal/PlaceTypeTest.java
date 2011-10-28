package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.PlaceType;

public class PlaceTypeTest extends DomainTest{

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
		assertEquals(1, placeType.getId());
	}
	
	@Override
	public void testSelect() {
		placeTypeDao.insert(placeType);
		
		PlaceType postPlaceType = (PlaceType) placeTypeDao.select(placeType.getId());
		
		assertTrue(postPlaceType.getText().equals(placeType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		placeTypeDao.insert(placeType);
		assertEquals(1, placeTypeDao.count());
		placeTypeDao.delete(placeType);
		assertEquals(0, placeTypeDao.count());
	}
	
}
