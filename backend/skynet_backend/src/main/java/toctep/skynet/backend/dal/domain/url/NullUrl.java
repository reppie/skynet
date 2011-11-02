package toctep.skynet.backend.dal.domain.url;


public class NullUrl implements IUrl{

	private static NullUrl instance;
	
	public static NullUrl getInstance() {
		if (instance == null) {
			instance = new NullUrl();
		}
		return instance;
	}
	
	private NullUrl() { }
	
	@Override
	public String getId() {
		return null;
	}

}
