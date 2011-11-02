package toctep.skynet.backend.dal.domain.tweet;

public class NullKeyword implements IKeyword {

	private static NullKeyword instance;
	
	public static NullKeyword getInstance() {
		if (instance == null) {
			instance = new NullKeyword();
		}
		return instance;
	}
	
	private NullKeyword() { }
	
	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getKeyword() {
		return "";
	}

}
