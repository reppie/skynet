package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.place.IPlaceType;
import toctep.skynet.backend.dal.domain.place.NullPlaceType;
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
		
		IPlaceType postPlaceType = PlaceType.select(placeType.getId());
		assertTrue(postPlaceType.getText().equals(placeType.getText()));
		
		IPlaceType nullPlaceType = PlaceType.select(1000);
		assertTrue(nullPlaceType instanceof NullPlaceType);
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
