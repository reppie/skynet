package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.place.IPlaceType;
import toctep.skynet.backend.dal.domain.place.NullPlaceType;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.test.SkynetTest;

public class PlaceTypeTest extends SkynetTest implements DomainTest {

	private PlaceType placeType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		placeType = new PlaceType();
		
		text = "City";
		placeType.setText(text);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(placeType);
		assertTrue(text.equals(placeType.getText()));
	}
	
	@Test
	public void testInsert() {
		placeType.save();
		assertEquals(1, PlaceType.count());
		assertTrue(new Integer(1).equals(placeType.getId()));
	}
	
	@Test
	public void testSelect() {
		placeType.save();
		
		IPlaceType postPlaceType = PlaceType.select(placeType.getId());
		assertTrue(postPlaceType.getText().equals(placeType.getText()));
		
		IPlaceType nullPlaceType = PlaceType.select(1000);
		assertTrue(nullPlaceType instanceof NullPlaceType);
	}
	
	@Test
	public void testDelete() {
		placeType.save();
		assertEquals(1, PlaceType.count());
		placeType.delete();
		assertEquals(0, PlaceType.count());
	}

	@Test
	public void testExists() {
		placeType.save();
		assertTrue(PlaceType.exists(placeType));
	}
	
}
