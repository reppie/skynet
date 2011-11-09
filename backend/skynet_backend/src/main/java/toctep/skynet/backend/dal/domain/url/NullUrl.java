package toctep.skynet.backend.dal.domain.url;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullUrl extends NullDomain implements IUrl {

	private static NullUrl instance;
	
	public static NullUrl getInstance() {
		if (instance == null) {
			instance = new NullUrl();
		}
		return instance;
	}
	
	@Override
	public String getId() {
		return null;
	}

	@Override
	public void save() {}

}
