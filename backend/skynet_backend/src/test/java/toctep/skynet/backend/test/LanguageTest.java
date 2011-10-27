package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.Language;

public class LanguageTest extends DomainTest{

	@Override
	public void testCreate() { 
		Language language = new Language();
		assertNotNull(language);
		
		String text = "English";
		language.setText(text);
		assertTrue(text.equals(language.getText()));
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
