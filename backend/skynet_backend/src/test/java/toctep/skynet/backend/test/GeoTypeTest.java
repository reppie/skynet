package toctep.skynet.backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
