package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;

public interface IPlace {
	
	public PlaceType getType();
	public BoundingBox getBoundingBox();
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
	public Url getUrl();
	public String getAppId();
}
