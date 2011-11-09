package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullBoundingBox extends NullDomain<Integer> implements IBoundingBox {

	private static NullBoundingBox instance;
	
	public static NullBoundingBox getInstance() {
		if (instance == null) {
			instance = new NullBoundingBox();
		}
		return instance;
	}
	
	@Override
	public String getCoordinates() {
		return "";
	}

	@Override
	public IBoundingBoxType getType() {
		return NullBoundingBoxType.getInstance();
	}
	
}
