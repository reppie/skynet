package toctep.skynet.backend.dal.domain.language;

public class NullLanguage implements ILanguage {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
