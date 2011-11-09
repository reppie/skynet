package toctep.skynet.backend.dal.domain.keyword;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullKeyword extends NullDomain<Integer> implements IKeyword {

	private static NullKeyword instance;
	
	public static NullKeyword getInstance() {
		if (instance == null) {
			instance = new NullKeyword();
		}
		return instance;
	}
	
	@Override
	public String getKeyword() {
		return "";
	}

}
