package toctep.skynet.backend.test.dal;

import toctep.skynet.backend.dal.domain.GeoType;
import toctep.skynet.backend.dal.domain.Hashtag;

public class HashtagTest extends DomainTest{

	@Override
	public void testCreate() { 
		Hashtag hashtag = new Hashtag();
		assertNotNull(hashtag);
		
		String text = "toctep";
		hashtag.setText(text);
		assertTrue(text.equals(hashtag.getText()));
	}

	@Override
	public void testInsert() {
		Hashtag preHashtag = new Hashtag();
		
		String text = "Test";
		preHashtag.setText(text);
		
		hashtagDao.insert(preHashtag);
		assertEquals(1, hashtagDao.count());
		
		Hashtag postHashtag = (Hashtag) hashtagDao.select(preHashtag.getId());
		assertTrue(postHashtag.getText().equals(preHashtag.getText()));
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
		GeoType geoType = new GeoType();
		assertNotNull(geoType);
		geoTypeDao.insert(geoType);
		assertEquals(1, geoTypeDao.count());
		geoTypeDao.delete(geoType);
		assertEquals(0, geoTypeDao.count());		
	}

}
