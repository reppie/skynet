package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Country;

public class CountryTest extends DomainTest{

	private Country country;
	
	private String id;
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		country = new Country();
		
		String id = "NL";

		country.setId(id);
		assertTrue(id.equals(country.getId()));
		
		String text = "Netherlands";
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
		Country preCountry = new Country();
		
		String id = "NL";
		preCountry.setId(id);
		
		String text = "Netherlands";
		preCountry.setText(text);
		
		countryDao.insert(preCountry);
		assertEquals(1, countryDao.count());
		
		Country postCountry = (Country) countryDao.select(preCountry.getId());
		assertTrue(postCountry.getText().equals(preCountry.getText()));
		countryDao.insert(country);
		assertEquals(1, countryDao.count());
		assertEquals(1, country.getId());

	}
	
	@Override
	public void testSelect() {
		countryDao.insert(country);
		
		Country postCountry = (Country) countryDao.select(country.getId());
		assertTrue(postCountry.getText().equals(country.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void testDelete() {
		countryDao.insert(country);
		assertEquals(1, countryDao.count());
		countryDao.delete(country);
		assertEquals(0, countryDao.count());		
	}
	
}
