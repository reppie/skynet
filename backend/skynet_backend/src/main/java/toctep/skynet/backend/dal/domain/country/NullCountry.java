package toctep.skynet.backend.dal.domain.country;

public class NullCountry implements ICountry {

	@Override
	public String getId() {
		return "";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
