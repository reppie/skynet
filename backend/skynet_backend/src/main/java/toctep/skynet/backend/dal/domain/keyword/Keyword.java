package toctep.skynet.backend.dal.domain.keyword;

import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Keyword extends Domain<Integer> implements IKeyword {
	
	private String keyword = "";
	
	public Keyword() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getKeywordDao());
	}
	
	@Override
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
		this.keyword = keyword.toLowerCase();
	}
	
	public static IKeyword select(Integer id) {
		KeywordDao dao = DaoFacadeImpl.getInstance().getKeywordDao();
		
		if (dao.exists(id)) {
			return (Keyword) dao.select(id);
		}
		
		return NullKeyword.getInstance();
	}
	
	
	public static IKeyword select(String text) {
		KeywordDao dao = DaoFacadeImpl.getInstance().getKeywordDao();
		return dao.select(text);
	}
	
	public static boolean exists(Keyword keyword) {
		KeywordDao dao = DaoFacadeImpl.getInstance().getKeywordDao();
		return dao.exists(keyword);
	}
}
