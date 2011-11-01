package toctep.skynet.backend.dal.domain.hashtag;

public class NullHashtag implements IHashtag {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
