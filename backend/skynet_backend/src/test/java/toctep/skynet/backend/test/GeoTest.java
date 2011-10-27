package toctep.skynet.backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
