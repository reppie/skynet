package toctep.skynet.backend.dal.domain.sourcetype;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullSourceType extends NullDomain<Integer> implements ISourceType {

	private static NullSourceType instance;
	
	public static NullSourceType getInstance() {
		if (instance == null) {
			instance = new NullSourceType();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
