package toctep.skynet.backend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.BoundingBoxType;

public class BoundingBoxTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		BoundingBoxType boundingBoxType = new BoundingBoxType();
		assertNotNull(boundingBoxType);
		
		String text = "Point";
		boundingBoxType.setText(text);
		assertTrue(text.equals(boundingBoxType.getText()));
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
