package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBoxType implements IBoundingBoxType<Long> {

	@Override
	public String getText() {
		return "";
	}

	@Override
	public Long getId() {
		return 0L;
	}
	
}
