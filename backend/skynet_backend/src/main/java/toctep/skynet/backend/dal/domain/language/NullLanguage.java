package toctep.skynet.backend.dal.domain.language;

public class NullLanguage implements ILanguage {

	@Override
	public String getId() {
		return "NULL";
	}
	
	@Override
	public String getText() {
		return "";
	}

}
