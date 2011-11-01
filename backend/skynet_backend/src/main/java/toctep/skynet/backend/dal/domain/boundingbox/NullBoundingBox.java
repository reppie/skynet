package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBox implements IBoundingBox{

	@Override
	public String getCoordinates() {
		return "";
	}

	@Override
	public IBoundingBoxType getType() {
		return new NullBoundingBoxType();
	}
}
