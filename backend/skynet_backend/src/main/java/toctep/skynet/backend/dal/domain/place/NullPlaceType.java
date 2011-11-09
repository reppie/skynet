package toctep.skynet.backend.dal.domain.place;

public final class NullPlaceType implements IPlaceType {

	private static NullPlaceType instance;
	
	public static NullPlaceType getInstance() {
		if (instance == null) {
			instance = new NullPlaceType();
		}
		return instance;
	}
	
	private NullPlaceType() { }
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

	@Override
	public void save() {
	}

}
