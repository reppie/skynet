package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.Country;

public class CountryTest extends DomainTest{

	@Override
	public void testCreate() { 
		Country country = new Country();
		assertNotNull(country);
		
		String code = "NL";
		country.setId(code);
		assertTrue(code.equals(country.getId()));
		
		String text = "Netherlands";
		country.setText(text);
		assertTrue(text.equals(country.getText()));
	}

	@Override
	public void testInsert() {
		Country preCountry = new Country();
		
		String code = "NL";
		preCountry.setId(code);
		
		String text = "Netherlands";
		preCountry.setText(text);
		
		countryDao.insert(preCountry);
		assertEquals(1, countryDao.count());
		
		Country postCountry = (Country) countryDao.select(preCountry.getId());
		assertTrue(postCountry.getText().equals(preCountry.getText()));
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
		Country country = new Country();
		assertNotNull(country);
		countryDao.insert(country);
		assertEquals(1, countryDao.count());
		countryDao.delete(country);
		assertEquals(0, countryDao.count());		
	}
	
}
