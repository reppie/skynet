package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.language.NullLanguage;

public class LanguageTest extends DomainTest {

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
		assertTrue(new Integer(1).equals(language.getId()));
	}
	
	@Override
	public void testSelect() {
		language.save();
		
		ILanguage postLanguage = Language.select(language.getId());
		
		assertTrue(postLanguage.getText().equals(language.getText()));
		
		ILanguage nullLanguage = Language.select(1000);
		assertTrue(nullLanguage instanceof NullLanguage);
	}
	
	@Override
	public void testDelete() {
		language.save();
		assertEquals(1, languageDao.count());
		language.delete();
		assertEquals(0, languageDao.count());		
	}

	@Override
	public void testExists() {
		language.save();
		assertTrue(languageDao.exists(language));
	}

}
