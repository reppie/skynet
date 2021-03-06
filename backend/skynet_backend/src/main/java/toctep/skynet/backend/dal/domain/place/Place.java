package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;

public class Place extends Domain<String> implements IPlace {

	private IPlaceType type 			= NullPlaceType.getInstance();
	private IBoundingBox boundingBox 	= NullBoundingBox.getInstance();
	private String name					= "";
	private String fullName				= "";
	private ICountry country 			= NullCountry.getInstance();
	private String streetAddress		= "";
	private String locality				= "";
	private String region				= "";
	private String iso3					= "";
	private String postalCode			= "";
	private String phone				= "";
	private String twitter				= "";
	private IUrl url 					= NullUrl.getInstance();
	private String appId				= "";

	public Place() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getPlaceDao());
	}
	
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
	public void save() {
		boundingBox.save();
		url.save();
		type.save();
		country.save();
		
		super.save();
	}
	
	public static IPlace select(String id) {
		PlaceDao dao = DaoFacadeImpl.getInstance().getPlaceDao();
		
		if (dao.exists(id)) {
			return (Place) dao.select(id);
		}
		
		return NullPlace.getInstance();
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getPlaceDao().count();
	}
	
	public static boolean exists(Place place) {
		return DaoFacadeImpl.getInstance().getPlaceDao().exists(place);
	}
	
}
