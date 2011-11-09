package toctep.skynet.backend.dal.domain.hashtag;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullHashtag extends NullDomain implements IHashtag {

	private static NullHashtag instance;
	
	public static NullHashtag getInstance() {
		if (instance == null) {
			instance = new NullHashtag();
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
