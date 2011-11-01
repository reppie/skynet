package toctep.skynet.backend.dal.domain.tweet;

public class NullSourceType implements ISourceType {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
