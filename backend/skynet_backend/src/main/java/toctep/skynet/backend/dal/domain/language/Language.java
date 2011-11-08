package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Language extends Domain<Integer> implements ILanguage {

	private String text = "";
	
	public Language() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getLanguageDao());
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public static ILanguage select(Integer id) {
		LanguageDao dao = DaoFacadeImpl.getInstance().getLanguageDao();
		
		if (dao.exists(id)) {
			return (Language) dao.select(id);
		}
		
		return NullLanguage.getInstance();
	}
	
}

