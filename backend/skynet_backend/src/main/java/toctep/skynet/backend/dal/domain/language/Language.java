package toctep.skynet.backend.dal.domain.language;

import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Language extends Domain<Long> implements ILanguage {

	private String text = "";
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getLanguageDao();
	}
	
	public static ILanguage select(Long id) {
		LanguageDao dao = DaoFacadeImpl.getInstance().getLanguageDao();
		
		if (dao.exists(id)) {
			return (Language) dao.select(id);
		}
		
		return NullLanguage.getInstance();
	}
	
}

