package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBoxType implements IBoundingBoxType {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
