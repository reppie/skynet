package toctep.skynet.backend.dal.domain.hashtag;

public class NullHashtag implements IHashtag {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
