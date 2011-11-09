package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;

public class CountryTest extends DomainTest {

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
	
	@Override
	public void testCreate() { 
		assertNotNull(country);
		assertTrue(id.equals(country.getId()));
		assertTrue(text.equals(country.getText()));
	}

	@Override
	public void testInsert() {
		country.save();
		assertEquals(1, countryDao.count());
	}
	
	@Override
	public void testSelect() {
		country.save();
		
		ICountry postCountry = Country.select(country.getId());
		assertTrue(postCountry.getText().equals(country.getText()));
		
		ICountry nullCountry = Country.select("ThisCountryDoesNotExist");
		assertTrue(nullCountry instanceof NullCountry);
	}
	
	@Override
	public void testDelete() {
		country.save();
		assertEquals(1, countryDao.count());
		country.delete();
		assertEquals(0, countryDao.count());		
	}

	@Override
	public void testExists() {
		country.save();
		assertTrue(countryDao.exists(country));
	}
	
}
