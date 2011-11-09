package toctep.skynet.backend.dal.domain.url;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullUrl extends NullDomain<String> implements IUrl {

	private static NullUrl instance;
	
	public static NullUrl getInstance() {
		if (instance == null) {
			instance = new NullUrl();
		}
		return instance;
	}

}
