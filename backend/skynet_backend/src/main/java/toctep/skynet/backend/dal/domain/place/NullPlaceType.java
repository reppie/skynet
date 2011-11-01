package toctep.skynet.backend.dal.domain.place;

public class NullPlaceType implements IPlaceType {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
