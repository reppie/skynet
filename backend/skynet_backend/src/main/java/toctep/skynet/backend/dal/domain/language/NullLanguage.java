package toctep.skynet.backend.dal.domain.language;

public class NullLanguage implements ILanguage {

	@Override
	public Long getId() {
		return 0L;
	}
	
	@Override
	public String getText() {
		return "";
	}

}
