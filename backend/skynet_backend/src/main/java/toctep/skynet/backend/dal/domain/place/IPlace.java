package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.url.IUrl;

public interface IPlace {
	
	public PlaceType getType();
	public IBoundingBox getBoundingBox();
	public String getName();
	public String getFullName();
	public Country getCountry();
	public String getStreetAddress();
	public String getLocality();
	public String getRegion();
	public String getIso3();
	public String getPostalCode();
	public String getPhone();
	public String getTwitter();
	public IUrl getUrl();
	public String getAppId();
}
