package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.PlaceType;

public class PlaceTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		PlaceType placeType = new PlaceType();
		assertNotNull(placeType);
		
		String text = "City";
		placeType.setText(text);
		assertTrue(text.equals(placeType.getText()));
	}

	@Override
	public void testDelete() {
		PlaceType placeType = new PlaceType();
		assertNotNull(placeType);
		placeTypeDao.insert(placeType);
		assertEquals(1, placeTypeDao.count());
		placeTypeDao.delete(placeType);
		assertEquals(0, placeTypeDao.count());
	}

	@Override
	public void testInsert() {
		PlaceType prePlaceType = new PlaceType();
		
		String text = "test";
		prePlaceType.setText(text);
		
		placeTypeDao.insert(prePlaceType);
		assertEquals(1, placeTypeDao.count());
		
		PlaceType postPlaceType = (PlaceType) placeTypeDao.select(prePlaceType.getId());
		
		assertTrue(postPlaceType.getText().equals(prePlaceType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
