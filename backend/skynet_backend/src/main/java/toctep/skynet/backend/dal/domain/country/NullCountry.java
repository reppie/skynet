package toctep.skynet.backend.dal.domain.country;


public class NullCountry implements ICountry {

	private static NullCountry instance;
	
	public static NullCountry getInstance() {
		if (instance == null) {
			instance = new NullCountry();
		}
		return instance;
	}
	
	private NullCountry() { }		
	
	@Override
	public String getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
