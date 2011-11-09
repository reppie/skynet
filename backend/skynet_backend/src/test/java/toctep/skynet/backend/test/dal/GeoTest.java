package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.geo.Geo;
import toctep.skynet.backend.dal.domain.geo.GeoType;

public class GeoTest extends DomainTest{

	private Geo geo;
	
	private GeoType geoType;
	private String coordinates;
	
	@Override
	public void setUp() {
		super.setUp();
		
		geo = new Geo();
		
		geoType = new GeoType();
		geoType.setText("test");
		geo.setType(geoType);
		
		coordinates = "58.17, 68.20";
		geo.setCoordinates(coordinates);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(geo);
		assertTrue(geo.getType().equals(geoType));
		assertTrue(coordinates.equals(geo.getCoordinates()));
	}

	@Override
	public void testInsert() {
		geo.save();
		assertEquals(1, geoDao.count());
		assertTrue(new Integer(1).equals(geo.getId()));
	}
	
	@Override
	public void testSelect() {
		geo.save();
		
		Geo postGeo = (Geo) geoDao.select(geo.getId());
		
		assertTrue(postGeo.getType().getId().equals(geo.getType().getId()));
		assertTrue(postGeo.getCoordinates().equals(geo.getCoordinates()));
	}
	
	@Override
	public void testDelete() {
		geo.save();
		assertEquals(1, geoDao.count());
		geo.delete();
		assertEquals(0, geoDao.count());		
	}

	@Override
	public void testExists() {
		geo.save();
		assertTrue(geoDao.exists(geo));
	}
	
}
