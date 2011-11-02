package toctep.skynet.backend.dal.domain.tweet;


public class NullSourceType implements ISourceType {

	private static NullSourceType instance;
	
	public static NullSourceType getInstance() {
		if (instance == null) {
			instance = new NullSourceType();
		}
		return instance;
	}
	
	private NullSourceType() { }
	
	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
