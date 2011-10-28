package toctep.skynet.backend.test.dal;

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
	public void testInsert() {
		Language preLanguage = new Language();
		
		String text = "Test";
		preLanguage.setText(text);
		
		languageDao.insert(preLanguage);
		assertEquals(1, languageDao.count());
		
		Language postLanguage = (Language) languageDao.select(preLanguage.getId());
		assertTrue(postLanguage.getText().equals(preLanguage.getText()));
	}
	
	@Override
	public void testSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		Language language = new Language();
		assertNotNull(language);
		languageDao.insert(language);
		assertEquals(1, languageDao.count());
		languageDao.delete(language);
		assertEquals(0, languageDao.count());		
	}

}
