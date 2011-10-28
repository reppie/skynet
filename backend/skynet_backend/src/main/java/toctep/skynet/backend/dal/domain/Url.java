package toctep.skynet.backend.dal.domain;

public class Url extends DomainStringPk {

	@Override
	public void setDao() {
		dao = daoFacade.getUrlDao();
	}
}
