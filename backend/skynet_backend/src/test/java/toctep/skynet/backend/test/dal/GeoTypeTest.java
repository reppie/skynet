package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.GeoType;

public class GeoTypeTest extends DomainTest{

	private GeoType geoType;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		geoType = new GeoType();
		
		text = "Point";
		geoType.setText(text);
	}
	
	@Override
	public void testCreate() { 
		assertNotNull(geoType);
		assertTrue(text.equals(geoType.getText()));
	}

	@Override
	public void testInsert() {
		geoTypeDao.insert(geoType);
		assertEquals(1, geoTypeDao.count());
		assertEquals(1, geoType.getId());
	}
	
	@Override
	public void testSelect() {
		geoTypeDao.insert(geoType);
		
		GeoType postGeoType = (GeoType) geoTypeDao.select(geoType.getId());
		
		assertTrue(postGeoType.getText().equals(geoType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		geoTypeDao.insert(geoType);
		assertEquals(1, geoTypeDao.count());
		geoTypeDao.delete(geoType);
		assertEquals(0, geoTypeDao.count());		
	}
	
}
