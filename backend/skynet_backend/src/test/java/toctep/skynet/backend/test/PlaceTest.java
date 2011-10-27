package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.BoundingBox;
import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.PlaceType;

public class PlaceTest extends DomainTest{

	@Override
	public void testCreate() { 
		Place place = new Place();
		assertNotNull(place);
		
		String twitterId = "hex";
		place.setTwitterId(twitterId);
		assertTrue(twitterId.equals(place.getTwitterId()));
		
		PlaceType placeType = new PlaceType();
		place.setType(placeType);
		assertTrue(place.getType() == placeType);
		
		BoundingBox boundingBox = new BoundingBox();
		place.setBoundingBox(boundingBox);
		assertTrue(place.getBoundingBox() == boundingBox);
		
		String name = "TestName";
		place.setName(name);
		assertTrue(name.equals(place.getName()));
		
		String fullName = "TestFullName";
		place.setFullName(fullName);
		assertTrue(fullName.equals(place.getFullName()));
		
		Country country = new Country();
		place.setCountry(country);
		assertTrue(place.getCountry() == country);
		
		String streetAddress = "Teststreet";
		place.setStreetAddress(streetAddress);
		assertTrue(streetAddress.equals(place.getStreetAddress()));
		
		String locality = "TestLocality";
		place.setLocality(locality);
		assertTrue(locality.equals(place.getLocality()));
		
		String region = "TestRegion";
		place.setRegion(region);
		assertTrue(region.equals(place.getRegion()));
		
		String iso3 = "TestIso3";
		place.setIso3(iso3);
		assertTrue(iso3.equals(place.getIso3()));
		
		String postalCode = "TestPostalCode";
		place.setPostalCode(postalCode);
		assertTrue(postalCode.equals(place.getPostalCode()));
		
		String phone = "TestPhone";
		place.setPhone(phone);
		assertTrue(phone.equals(place.getPhone()));
		
		String twitter = "TestTwitter";
		place.setTwitter(twitter);
		assertTrue(twitter.equals(place.getTwitter()));
		
		String url = "TestUrl";
		place.setUrl(url);
		assertTrue(url.equals(place.getUrl()));
		
		String appId = "TestAppId";
		place.setAppId(appId);
		assertTrue(appId.equals(place.getAppId()));
	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
