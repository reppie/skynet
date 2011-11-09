package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.test.SkynetTest;

public class CountryTest extends SkynetTest implements IDomainTest {

	private Country country;
	
	private String id;
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		country = new Country();
		
		id = "NL";
		country.setId(id);
		
		text = "Netherlands";
		country.setText(text);
	}
	
	@Test
	public void testCreate() { 
		assertNotNull(country);
		assertTrue(id.equals(country.getId()));
		assertTrue(text.equals(country.getText()));
	}

	@Test
	public void testInsert() {
		country.save();
		assertEquals(1, Country.count());
	}
	
	@Test
	public void testSelect() {
		country.save();
		
		ICountry postCountry = Country.select(country.getId());
		assertTrue(postCountry.getText().equals(country.getText()));
		
		ICountry nullCountry = Country.select("ThisCountryDoesNotExist");
		assertTrue(nullCountry instanceof NullCountry);
	}
	
	@Test
	public void testDelete() {
		country.save();
		assertEquals(1, Country.count());
		country.delete();
		assertEquals(0, Country.count());		
	}

	@Test
	public void testExists() {
		country.save();
		assertTrue(Country.exists(country));
	}
	
}
