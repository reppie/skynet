package toctep.skynet.backend.test;

import toctep.skynet.backend.dal.domain.BoundingBox;
import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Place;
import toctep.skynet.backend.dal.domain.PlaceType;
import toctep.skynet.backend.dal.domain.User;

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
		Place place = new Place();
		assertNotNull(place);
		placeDao.insert(place);
		assertEquals(1, placeDao.count());
		placeDao.delete(place);
		assertEquals(0, placeDao.count());
	}

	@Override
	public void testInsert() {
		Place prePlace = new Place();
		
		String twitterId = "test";
		prePlace.setTwitterId(twitterId);
		
		PlaceType placeType = new PlaceType();
		prePlace.setType(placeType);
		
		BoundingBox boundingBox = new BoundingBox();
		prePlace.setBoundingBox(boundingBox);
		
		String name = "test";
		prePlace.setName(name);
		
		String fullName = "test";
		prePlace.setFullName(fullName);
		
		Country country = new Country();
		prePlace.setCountry(country);
		
		String streetAddress = "test";
		prePlace.setStreetAddress(streetAddress);
		
		String locality = "test";
		prePlace.setLocality(locality);
		
		String region = "test";
		prePlace.setRegion(region);
		
		String iso3 = "test";
		prePlace.setIso3(iso3);
		
		String postalCode = "test";
		prePlace.setPostalCode(postalCode);
		
		String phone = "test";
		prePlace.setPhone(phone);
		
		String twitter = "test";
		prePlace.setTwitter(twitter);
		
		String url = "test";
		prePlace.setUrl(url);
		
		String appId = "test";
		prePlace.setAppId(appId);
		
		placeDao.insert(prePlace);
		assertEquals(1, userDao.count());
		
		Place postPlace = (Place) placeDao.select(prePlace.getId());
		
		assertTrue(postPlace.getTwitterId().equals(prePlace.getTwitterId()));
		assertTrue(postPlace.getType().equals(prePlace.getType()));
		assertTrue(postPlace.getBoundingBox().equals(prePlace.getBoundingBox()));
		assertTrue(postPlace.getName().equals(prePlace.getName()));
		assertTrue(postPlace.getFullName().equals(prePlace.getFullName()));
		assertTrue(postPlace.getCountry().equals(prePlace.getCountry()));
		assertTrue(postPlace.getStreetAddress().equals(prePlace.getStreetAddress()));
		assertTrue(postPlace.getLocality().equals(prePlace.getStreetAddress()));
		assertTrue(postPlace.getRegion().equals(prePlace.getRegion()));
		assertTrue(postPlace.getIso3().equals(prePlace.getIso3()));
		assertTrue(postPlace.getPostalCode().equals(prePlace.getIso3()));
		assertTrue(postPlace.getPhone().equals(prePlace.getPhone()));
		assertTrue(postPlace.getTwitter().equals(prePlace.getTwitter()));
		assertTrue(postPlace.getUrl().equals(prePlace.getUrl()));
		assertTrue(postPlace.getAppId().equals(prePlace.getAppId()));
	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub
		
	}	
}
