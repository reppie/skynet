package toctep.skynet.backend.dal.domain.sourcetype;


public final class NullSourceType implements ISourceType {

	private static NullSourceType instance;
	
	public static NullSourceType getInstance() {
		if (instance == null) {
			instance = new NullSourceType();
		}
		return instance;
	}
	
	private NullSourceType() { }
	
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
