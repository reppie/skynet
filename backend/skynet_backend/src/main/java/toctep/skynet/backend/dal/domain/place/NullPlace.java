package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;

public class NullPlace implements IPlace{

	@Override
	public String getAppId() {
		return "";
	}

	@Override
	public IBoundingBox getBoundingBox() {
		return new NullBoundingBox();
	}

	@Override
	public ICountry getCountry() {
		return new NullCountry();
	}

	@Override
	public String getFullName() {
		return "";
	}

	@Override
	public String getIso3() {
		return "";
	}

	@Override
	public String getLocality() {
		return "";
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getPhone() {
		return "";
	}

	@Override
	public String getPostalCode() {
		return "";
	}

	@Override
	public String getRegion() {
		return "";
	}

	@Override
	public String getStreetAddress() {
		return "";
	}

	@Override
	public String getTwitter() {
		return "";
	}

	@Override
	public IPlaceType getType() {
		return new NullPlaceType();
	}

	@Override
	public Url getUrl() {
		return new NullUrl();
	}
	
}
