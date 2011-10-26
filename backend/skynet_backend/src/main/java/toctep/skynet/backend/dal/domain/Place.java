package toctep.skynet.backend.dal.domain;

public class Place extends Domain {

	private int twitterId;
	private PlaceType type;
	private BoundingBox boundingBox;
	private String name;
	private String fullName;
	private Country country;
	private String streetAddress;
	private String locality;
	private String region;
	private String iso3;
	private String postalCode;
	private String phone;
	private String twitter;
	private String url;
	private String appId;
	
	public Place(int twitterId, PlaceType placeType, BoundingBox boundingBox,
			String name, String fullName, Country country,
			String streetAddress, String locality, String region, String iso3,
			String postalCode, String phone, String twitter, String url,
			String appId) {
		this.twitterId = twitterId;
		this.type = placeType;
		this.boundingBox = boundingBox;
		this.name = name;
		this.fullName = fullName;
		this.country = country;
		this.streetAddress = streetAddress;
		this.locality = locality;
		this.region = region;
		this.iso3 = iso3;
		this.postalCode = postalCode;
		this.phone = phone;
		this.twitter = twitter;
		this.url = url;
		this.appId = appId;
	}

	public int getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(int twitterId) {
		this.twitterId = twitterId;
	}

	public PlaceType getType() {
		return type;
	}

	public void setType(PlaceType placeType) {
		this.type = placeType;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
}
