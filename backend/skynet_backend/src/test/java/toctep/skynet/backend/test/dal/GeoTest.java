package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Geo;
import toctep.skynet.backend.dal.domain.GeoType;

public class GeoTest extends DomainTest{

	private Geo geo;
	
	private GeoType geoType;
	private String coordinates;
	
	@Override
	public void setUp() {
		super.setUp();
		
		geo = new Geo();
		
		geoType = new GeoType();
		geo.setType(geoType);
		
		coordinates = "58.17, 68.20";
		geo.setCoordinates(coordinates);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(geo);
		assertTrue(geo.getType() == geoType);
		assertTrue(coordinates.equals(geo.getCoordinates()));
	}

	@Override
	public void testInsert() {
		geoDao.insert(geo);
		assertEquals(1, geoDao.count());
		assertEquals(1, geo.getId());
	}
	
	@Override
	public void testSelect() {
		geoDao.insert(geo);
		
		Geo postGeo = (Geo) geoDao.select(geo.getId());
		
		assertTrue(postGeo.getType().equals(geo.getType()));
		assertTrue(postGeo.getCoordinates().equals(geo.getCoordinates()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		geoDao.insert(geo);
		assertEquals(1, geoDao.count());
		geoDao.delete(geo);
		assertEquals(0, geoDao.count());		
	}
	
}
