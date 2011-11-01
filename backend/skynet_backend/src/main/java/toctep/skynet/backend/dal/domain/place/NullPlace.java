package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.domain.Country;
import toctep.skynet.backend.dal.domain.Url;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;

public class NullPlace implements IPlace{

	@Override
	public String getAppId() {
		return "";
	}

	@Override
	public BoundingBox getBoundingBox() {
		return new NullBoundingBox();
	}

	@Override
	public Country getCountry() {
		return new NullCountry();
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIso3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPostalCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStreetAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTwitter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Url getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
