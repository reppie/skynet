package toctep.skynet.backend.dal.domain.url;

import toctep.skynet.backend.dal.domain.DomainStringPk;

public class Url extends DomainStringPk implements IUrl{

	@Override
	public void setDao() {
		dao = daoFacade.getUrlDao();
	}
}
