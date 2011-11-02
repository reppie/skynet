package toctep.skynet.backend.dal.domain.hashtag;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Hashtag extends Domain<Long> implements IHashtag {

	private String text = "";
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getHashtagDao();
	}
	
	public static IHashtag select(Long id) {
		HashtagDao dao = DaoFacadeImpl.getInstance().getHashtagDao();
		
		if (dao.exists(id)) {
			return (Hashtag) dao.select(id);
		}
		
		return NullHashtag.getInstance();
	}
	
}
