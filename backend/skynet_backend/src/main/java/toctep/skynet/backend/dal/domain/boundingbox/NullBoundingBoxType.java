package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBoxType implements IBoundingBoxType {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
