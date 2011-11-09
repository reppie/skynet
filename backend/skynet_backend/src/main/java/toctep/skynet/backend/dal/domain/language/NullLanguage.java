package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.domain.NullDomain;

public final class NullLanguage extends NullDomain<Integer> implements ILanguage {

	private static NullLanguage instance;
	
	public static NullLanguage getInstance() {
		if (instance == null) {
			instance = new NullLanguage();
		}
		return instance;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
