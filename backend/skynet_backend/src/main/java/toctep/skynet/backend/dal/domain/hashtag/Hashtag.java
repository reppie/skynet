package toctep.skynet.backend.dal.domain.hashtag;

import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Hashtag extends Domain<Integer> implements IHashtag {

	private String text = "";
	
	public Hashtag() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getHashtagDao());
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public static IHashtag select(Integer id) {
		HashtagDao dao = DaoFacadeImpl.getInstance().getHashtagDao();
		
		if (dao.exists(id)) {
			return (Hashtag) dao.select(id);
		}
		
		return NullHashtag.getInstance();
	}
	
	public static IHashtag select(String text) {
		HashtagDao dao = DaoFacadeImpl.getInstance().getHashtagDao();
		return dao.select(text);
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getHashtagDao().count();
	}
	
	public static boolean exists(Hashtag hashtag) {
		return DaoFacadeImpl.getInstance().getHashtagDao().exists(hashtag);
	}
	
}
