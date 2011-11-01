package toctep.skynet.backend.dal.domain.tweet;

public class NullSourceType implements ISourceType {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
