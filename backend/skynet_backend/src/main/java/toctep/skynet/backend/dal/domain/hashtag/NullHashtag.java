package toctep.skynet.backend.dal.domain.hashtag;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullHashtag extends NullDomain<Integer> implements IHashtag {

	private static NullHashtag instance;
	
	public static NullHashtag getInstance() {
		if (instance == null) {
			instance = new NullHashtag();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
