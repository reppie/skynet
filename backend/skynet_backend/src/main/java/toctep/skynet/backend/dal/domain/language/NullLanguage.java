package toctep.skynet.backend.dal.domain.language;


public final class NullLanguage implements ILanguage {

	private static NullLanguage instance;
	
	public static NullLanguage getInstance() {
		if (instance == null) {
			instance = new NullLanguage();
		}
		return instance;
	}
	
	private NullLanguage() {}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

	@Override
	public void save() {}

}
