package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Country;

public class CountryTest extends DomainTest{

	private Country country;
	
	private String code;
	private String text;
	
	@Override
	public void setUp() {
		super.setUp();
		
		country = new Country();
		
		String code = "NL";
		country.setCode(code);
		
		String text = "Netherlands";
		country.setText(text);
	}
	
	@Override
	public void testCreate() { 
		assertNotNull(country);
		assertTrue(code.equals(country.getCode()));
		assertTrue(text.equals(country.getText()));
	}

	@Override
	public void testInsert() {
		countryDao.insert(country);
		assertEquals(1, countryDao.count());
		assertEquals(1, country.getId());
	}
	
	@Override
	public void testSelect() {
		countryDao.insert(country);
		
		Country postCountry = (Country) countryDao.select(country.getId());
		
		assertTrue(postCountry.getCode().equals(country.getCode()));
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
