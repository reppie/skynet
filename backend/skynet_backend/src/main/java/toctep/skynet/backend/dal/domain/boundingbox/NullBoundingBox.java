package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBox implements IBoundingBox<Long> {

	@Override
	public Long getId() {
		return 0L;
	}
	
	@Override
	public String getCoordinates() {
		return "";
	}

	@Override
	public IBoundingBoxType<Long> getType() {
		return new NullBoundingBoxType();
	}
	
}
