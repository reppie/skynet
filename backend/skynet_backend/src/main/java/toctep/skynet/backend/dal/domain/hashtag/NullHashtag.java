package toctep.skynet.backend.dal.domain.hashtag;

public final class NullHashtag implements IHashtag {

	private static NullHashtag instance;
	
	public static NullHashtag getInstance() {
		if (instance == null) {
			instance = new NullHashtag();
		}
		return instance;
	}
	
	private NullHashtag() { }
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

	@Override
	public void save() {
	}

}
