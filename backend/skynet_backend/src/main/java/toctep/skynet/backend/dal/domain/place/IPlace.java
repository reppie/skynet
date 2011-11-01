package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.country.Country;

public interface IPlace {
	
	public PlaceType getType();
	public IBoundingBox getBoundingBox();
	public String getName();
	public String getFullName();
	public ICountry getCountry();
	public String getStreetAddress();
	public String getLocality();
	public String getRegion();
	public String getIso3();
	public String getPostalCode();
	public String getPhone();
	public String getTwitter();
	public Url getUrl();
	public String getAppId();
}
