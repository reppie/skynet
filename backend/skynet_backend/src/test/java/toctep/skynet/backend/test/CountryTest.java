package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.BoundingBoxType;
import toctep.skynet.backend.dal.domain.Country;

public class CountryTest extends DomainTest{

	@Override
	public void testCreate() { 
		Country country = new Country();
		assertNotNull(country);
		
		String code = "NL";
		country.setCode(code);
		assertTrue(code.equals(country.getCode()));
		
		String text = "Netherlands";
		country.setText(text);
		assertTrue(text.equals(country.getText()));
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

	@Override
	public void testInsert() {
		Country preCountry = new Country();
		
		String code = "NL";
		preCountry.setCode(code);
		
		String text = "Netherlands";
		preCountry.setText(text);
		
		countryDao.insert(preCountry);
		assertEquals(1, countryDao.count());
		
		Country postCountry = (Country) countryDao.select(preCountry.getId());
		assertTrue(postCountry.getCode().equals(preCountry.getCode()));
		assertTrue(postCountry.getText().equals(preCountry.getText()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
