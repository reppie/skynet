package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.GeoType;

public class GeoTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		GeoType geoType = new GeoType();
		assertNotNull(geoType);
		
		String text = "Point";
		geoType.setText(text);
		assertTrue(text.equals(geoType.getText()));
	}

	@Override
	public void testDelete() {
		GeoType geoType = new GeoType();
		assertNotNull(geoType);
		geoTypeDao.insert(geoType);
		assertEquals(1, geoTypeDao.count());
		geoTypeDao.delete(geoType);
		assertEquals(0, geoTypeDao.count());		
	}

	@Override
	public void testInsert() {
		GeoType preGeoType = new GeoType();
		
		String text = "Point";
		preGeoType.setText(text);
		
		geoTypeDao.insert(preGeoType);
		assertEquals(1, geoTypeDao.count());
		
		GeoType postGeoType = (GeoType) geoTypeDao.select(preGeoType.getId());
		assertTrue(postGeoType.getText().equals(preGeoType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
