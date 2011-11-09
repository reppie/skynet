package toctep.skynet.backend.dal.domain.sourcetype;

import toctep.skynet.backend.dal.domain.NullDomain;


public final class NullSourceType extends NullDomain implements ISourceType {

	private static NullSourceType instance;
	
	public static NullSourceType getInstance() {
		if (instance == null) {
			instance = new NullSourceType();
		}
		return instance;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

	@Override
	public void save() {}

}
