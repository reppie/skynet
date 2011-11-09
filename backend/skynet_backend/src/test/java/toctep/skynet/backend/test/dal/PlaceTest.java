package toctep.skynet.backend.test.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.dal.domain.place.IPlace;
import toctep.skynet.backend.dal.domain.place.IPlaceType;
import toctep.skynet.backend.dal.domain.place.NullPlace;
import toctep.skynet.backend.dal.domain.place.NullPlaceType;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;
import toctep.skynet.backend.test.SkynetTest;

public class PlaceTest extends SkynetTest implements DomainTest {

	private Place place;
	
	private String id;
	private IPlaceType placeType;
	private IBoundingBox boundingBox;
	private String name;
	private String fullName;
	private ICountry country;
	private String streetAddress;
	private String locality;
	private String region;
	private String iso3;
	private String postalCode;
	private String phone;
	private String twitter;
	private IUrl url;
	private String appId;
	
	@Override
	public void setUp() {
		super.setUp();
		
		place = new Place();
		
		id = "0E";
		place.setId(id);
		
		placeType = NullPlaceType.getInstance();
		place.setType(placeType);
		
		boundingBox = NullBoundingBox.getInstance();
		place.setBoundingBox(boundingBox);
		
		name = "TestName";
		place.setName(name);
		
		fullName = "TestFullName";
		place.setFullName(fullName);
		
		country = NullCountry.getInstance();
		place.setCountry(country);
		
		streetAddress = "Teststreet";
		place.setStreetAddress(streetAddress);
		
		locality = "TestLocality";
		place.setLocality(locality);
		
		region = "TestRegion";
		place.setRegion(region);
		
		iso3 = "TestIso3";
		place.setIso3(iso3);
		
		postalCode = "TestPostalCode";
		place.setPostalCode(postalCode);
		
		phone = "TestPhone";
		place.setPhone(phone);
		
		twitter = "TestTwitter";
		place.setTwitter(twitter);
		
		url = NullUrl.getInstance();
		place.setUrl(url);
		
		appId = "TestAppId";
		place.setAppId(appId);
	}
	
	@Test
	public void testCreate() { 
		assertNotNull(place);
		assertTrue(id.equals(place.getId()));
		assertTrue(place.getType().equals(placeType));
		assertTrue(place.getBoundingBox().equals(boundingBox));
		assertTrue(name.equals(place.getName()));
		assertTrue(fullName.equals(place.getFullName()));
		assertTrue(place.getCountry().equals(country));
		assertTrue(streetAddress.equals(place.getStreetAddress()));
		assertTrue(locality.equals(place.getLocality()));
		assertTrue(region.equals(place.getRegion()));
		assertTrue(iso3.equals(place.getIso3()));
		assertTrue(postalCode.equals(place.getPostalCode()));
		assertTrue(phone.equals(place.getPhone()));
		assertTrue(twitter.equals(place.getTwitter()));
		assertTrue(url.equals(place.getUrl()));
		assertTrue(appId.equals(place.getAppId()));
	}

	@Test
	public void testInsert() {
		place.save();
		assertEquals(1, Place.count());
		assertEquals(id, place.getId());
	}
	
	@Test
	public void testSelect() {
		place.save();
		
		IPlace postPlace = Place.select(place.getId());
		
		assertTrue(postPlace.getType().equals(place.getType()));
		assertTrue(postPlace.getBoundingBox().equals(place.getBoundingBox()));
		assertTrue(postPlace.getName().equals(place.getName()));
		assertTrue(postPlace.getFullName().equals(place.getFullName()));
		assertTrue(postPlace.getCountry().equals(place.getCountry()));
		assertTrue(postPlace.getStreetAddress().equals(place.getStreetAddress()));
		assertTrue(postPlace.getLocality().equals(place.getLocality()));
		assertTrue(postPlace.getRegion().equals(place.getRegion()));
		assertTrue(postPlace.getIso3().equals(place.getIso3()));
		assertTrue(postPlace.getPostalCode().equals(place.getPostalCode()));
		assertTrue(postPlace.getPhone().equals(place.getPhone()));
		assertTrue(postPlace.getTwitter().equals(place.getTwitter()));
		assertTrue(postPlace.getUrl().equals(place.getUrl()));
		assertTrue(postPlace.getAppId().equals(place.getAppId()));
		
		IPlace nullPlace = Place.select("ThisPlaceDoesNotExist");
		assertTrue(nullPlace instanceof NullPlace);
	}
	
	@Test
	public void testDelete() {
		place.save();
		assertEquals(1, Place.count());
		place.delete();
		assertEquals(0, Place.count());
	}

	@Test
	public void testExists() {
		place.save();
		assertTrue(Place.exists(place));
	}
	
}
