package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class Place extends Domain<String> implements IPlace{

	private IPlaceType type 			= new NullPlaceType();
	private IBoundingBox boundingBox 	= new NullBoundingBox();
	private String name					= "";
	private String fullName				= "";
	private ICountry country 			= new NullCountry();
	private String streetAddress		= "";
	private String locality				= "";
	private String region				= "";
	private String iso3					= "";
	private String postalCode			= "";
	private String phone				= "";
	private String twitter				= "";
	private IUrl url 					= new NullUrl();
	private String appId				= "";

	public IPlaceType getType() {
		return type;
	}

	public void setType(IPlaceType placeType) {
		this.type = placeType;
	}

	public IBoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(IBoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public ICountry getCountry() {
		return country;
	}

	public void setCountry(ICountry country) {
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public IUrl getUrl() {
		return url;
	}

	public void setUrl(IUrl url) {
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public void setDao() {
		dao = getDaoFacade().getPlaceDao();		
	}
	
	@Override
	public void save() {
		if (boundingBox instanceof BoundingBox) {
			((BoundingBox) boundingBox).save();
			((BoundingBox) this.boundingBox).setId(((BoundingBox) boundingBox).getId());
		}
		
		if (url instanceof Url) {
			((Url) url).save();
			((Url) this.url).setId(((Url) url).getId());
		}
		
		if (type instanceof PlaceType) {
			((PlaceType) type).save();
			((PlaceType) this.type).setId(((PlaceType) type).getId());
		}
		
		if (country instanceof Country) {
			((Country) country).save();
			((Country) this.country).setId(((Country) country).getId());
		}
		
		super.save();
	}		
}
