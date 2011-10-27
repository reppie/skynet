package toctep.skynet.backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.PlaceType;

public class PlaceTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		PlaceType placeType = new PlaceType();
		assertNotNull(placeType);
		
		String text = "City";
		placeType.setText(text);
		assertTrue(text.equals(placeType.getText()));
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
