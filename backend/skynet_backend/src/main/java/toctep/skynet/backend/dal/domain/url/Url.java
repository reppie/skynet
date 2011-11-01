package toctep.skynet.backend.dal.domain.url;

import toctep.skynet.backend.dal.domain.Domain;

public class Url extends Domain<String> implements IUrl{

	@Override
	public void setDao() {
		dao = daoFacade.getUrlDao();
	}
}
