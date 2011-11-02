package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.boundingbox.IBoundingBox;
import toctep.skynet.backend.dal.domain.boundingbox.NullBoundingBox;
import toctep.skynet.backend.dal.domain.country.ICountry;
import toctep.skynet.backend.dal.domain.country.NullCountry;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.NullUrl;

public final class NullPlace implements IPlace {

	private static NullPlace instance;
	
	public static NullPlace getInstance() {
		if (instance == null) {
			instance = new NullPlace();
		}
		return instance;
	}
	
	private NullPlace() { }
	
	@Override
	public String getId() {
		return null;
	}
	
	@Override
	public String getAppId() {
		return "";
	}

	@Override
	public IBoundingBox getBoundingBox() {
		return NullBoundingBox.getInstance();
	}

	@Override
	public ICountry getCountry() {
		return NullCountry.getInstance();
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


	public IPlaceType getType() {
		return NullPlaceType.getInstance();
	}

	@Override
	public IUrl getUrl() {
		return NullUrl.getInstance();
	}
	
}
