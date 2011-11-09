package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullLanguage extends NullDomain implements ILanguage {

	private static NullLanguage instance;
	
	public static NullLanguage getInstance() {
		if (instance == null) {
			instance = new NullLanguage();
		}
		return instance;
	}
	
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
