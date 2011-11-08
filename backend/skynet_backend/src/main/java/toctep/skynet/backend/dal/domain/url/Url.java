package toctep.skynet.backend.dal.domain.url;

import toctep.skynet.backend.dal.dao.UrlDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Url extends Domain<String> implements IUrl{

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getUrlDao();
	}
	
	public static IUrl select(String id) {
		UrlDao dao = DaoFacadeImpl.getInstance().getUrlDao();
		
		if (dao.exists(id)) {
			return (Url) dao.select(id);
		}
		
		return NullUrl.getInstance();
	}
}
