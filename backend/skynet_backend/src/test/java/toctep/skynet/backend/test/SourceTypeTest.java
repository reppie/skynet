package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.SourceType;

public class SourceTypeTest extends DomainTest{

	@Override
	public void testCreate() { 
		SourceType SourceType = new SourceType();
		assertNotNull(SourceType);
		
		String text = "Web";
		SourceType.setSourceType(text);
		assertTrue(text.equals(SourceType.getSourceType()));
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
