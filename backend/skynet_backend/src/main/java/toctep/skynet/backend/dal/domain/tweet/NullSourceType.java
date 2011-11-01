package toctep.skynet.backend.dal.domain.tweet;

public class NullSourceType implements ISourceType {

	@Override
	public Long getId() {
		return 0L;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
