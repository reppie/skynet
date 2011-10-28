package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Geo;
import toctep.skynet.backend.dal.domain.GeoType;

public class GeoTest extends DomainTest{

	@Override
	public void testCreate() { 
		Geo geo = new Geo();
		assertNotNull(geo);
		
		GeoType geoType = new GeoType();
		geo.setType(geoType);
		assertTrue(geo.getType() == geoType);
		
		String coordinates = "58.17, 68.20";
		geo.setCoordinates(coordinates);
		assertTrue(coordinates.equals(geo.getCoordinates()));
	}

	@Override
	public void testDelete() {
		Geo geo = new Geo();
		assertNotNull(geo);
		geoDao.insert(geo);
		assertEquals(1, geoDao.count());
		geoDao.delete(geo);
		assertEquals(0, geoDao.count());		
	}

	@Override
	public void testInsert() {
		Geo preGeo = new Geo();
		
		GeoType geoType = new GeoType();
		preGeo.setType(geoType);
		
		String coordinates = "58.18, 20.11";
		preGeo.setCoordinates(coordinates);
		
		geoDao.insert(preGeo);
		assertEquals(1, geoDao.count());
		
		Geo postGeo = (Geo) geoDao.select(preGeo.getId());
		assertTrue(postGeo.getType().equals(preGeo.getType()));
		assertTrue(postGeo.getCoordinates().equals(preGeo.getCoordinates()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
