package toctep.skynet.backend.dal.domain.place;

public class NullPlaceType implements IPlaceType {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
