package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.IDomain;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.url.IUrl;

public interface IPlace extends IDomain<String> {
	
	IPlaceType getType();
	IBoundingBox getBoundingBox();
	String getName();
	String getFullName();
	ICountry getCountry();
	String getStreetAddress();
	String getLocality();
	String getRegion();
	String getIso3();
	String getPostalCode();
	String getPhone();
	String getTwitter();
	IUrl getUrl();
	String getAppId();
	
}
