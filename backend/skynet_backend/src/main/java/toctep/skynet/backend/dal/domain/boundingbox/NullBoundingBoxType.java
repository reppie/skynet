package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBoxType implements IBoundingBoxType {

	@Override
	public Long getId() {
		return 0L;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
