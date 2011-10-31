package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Language;

public class LanguageTest extends DomainTest{

	private Language language;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		language = new Language();
		
		text = "en";
		language.setText(text);
	}
	
	@Override
	public void testCreate() {
		assertNotNull(language);
		assertTrue(text.equals(language.getText()));
	}

	@Override
	public void testInsert() {
		language.save();
		assertEquals(1, languageDao.count());
		assertEquals(1, language.getId());
	}
	
	@Override
	public void testSelect() {
		languageDao.insert(language);
		
		Language postLanguage = (Language) languageDao.select(language.getId());
		
		assertTrue(postLanguage.getText().equals(language.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		languageDao.insert(language);
		assertEquals(1, languageDao.count());
		languageDao.delete(language);
		assertEquals(0, languageDao.count());		
	}

}
