package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.domain.IDomain;

public interface ILanguage extends IDomain<Long> {
	
	public String getText();
	
}
