package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullBoundingBoxType extends NullDomain<Integer> implements IBoundingBoxType {

	private static NullBoundingBoxType instance;
	
	public static NullBoundingBoxType getInstance() {
		if (instance == null) {
			instance = new NullBoundingBoxType();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
