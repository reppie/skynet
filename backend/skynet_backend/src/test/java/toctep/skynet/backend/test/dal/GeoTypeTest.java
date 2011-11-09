package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.geo.GeoType;
import toctep.skynet.backend.dal.domain.geo.IGeoType;
import toctep.skynet.backend.dal.domain.geo.NullGeoType;
import toctep.skynet.backend.test.SkynetTest;

public class GeoTypeTest extends SkynetTest implements IDomainTest {

	private GeoType geoType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		geoType = new GeoType();
		
		text = "Point";
		geoType.setText(text);
	}
	
	@Test
	public void testCreate() { 
		assertNotNull(geoType);
		assertTrue(text.equals(geoType.getText()));
	}

	@Test
	public void testInsert() {
		geoType.save();
		assertEquals(1, GeoType.count());
		assertTrue(new Integer(1).equals(geoType.getId()));
	}
	
	@Test
	public void testSelect() {
		geoType.save();
		
		IGeoType postGeoType = GeoType.select(geoType.getId());
		assertTrue(postGeoType.getText().equals(geoType.getText()));
		
		IGeoType nullGeoType = GeoType.select(1000);
		assertTrue(nullGeoType instanceof NullGeoType);
	}
	
	@Test
	public void testDelete() {
		geoType.save();
		assertEquals(1, GeoType.count());
		geoType.delete();
		assertEquals(0, GeoType.count());		
	}

	@Test
	public void testExists() {
		geoType.save();
		assertTrue(GeoType.exists(geoType));
	}
	
}
