package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.language.ILanguage;
import toctep.skynet.backend.dal.domain.language.Language;
import toctep.skynet.backend.dal.domain.language.NullLanguage;
import toctep.skynet.backend.test.SkynetTest;

public class LanguageTest extends SkynetTest implements DomainTest {

	private Language language;
	
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		language = new Language();
		
		text = "en";
		language.setText(text);
	}
	
	@Test
	public void testCreate() {
		assertNotNull(language);
		assertTrue(text.equals(language.getText()));
	}

	@Test
	public void testInsert() {
		language.save();
		assertEquals(1, Language.count());
		assertTrue(new Integer(1).equals(language.getId()));
	}
	
	@Test
	public void testSelect() {
		language.save();
		
		ILanguage postLanguage = Language.select(language.getId());
		
		assertTrue(postLanguage.getText().equals(language.getText()));
		
		ILanguage nullLanguage = Language.select(1000);
		assertTrue(nullLanguage instanceof NullLanguage);
	}
	
	@Test
	public void testDelete() {
		language.save();
		assertEquals(1, Language.count());
		language.delete();
		assertEquals(0, Language.count());		
	}

	@Test
	public void testExists() {
		language.save();
		assertTrue(Language.exists(language));
	}

}
