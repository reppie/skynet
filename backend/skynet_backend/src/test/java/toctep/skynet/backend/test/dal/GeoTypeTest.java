package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.geo.GeoType;

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
		geoType.save();
		assertEquals(1, geoTypeDao.count());
		assertTrue(new Integer(1).equals(geoType.getId()));
	}
	
	@Override
	public void testSelect() {
		geoType.save();
		
		GeoType postGeoType = (GeoType) geoTypeDao.select(geoType.getId());
		
		assertTrue(postGeoType.getText().equals(geoType.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		geoType.save();
		assertEquals(1, geoTypeDao.count());
		geoType.delete();
		assertEquals(0, geoTypeDao.count());		
	}
	
}
