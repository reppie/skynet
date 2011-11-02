package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class SourceType extends Domain<Long> implements ISourceType {

	private String text = "";

	@Override
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getSourceTypeDao();
	}
	
	public static ISourceType select(Long id) {
		SourceTypeDao dao = DaoFacadeImpl.getInstance().getSourceTypeDao();
		
		if (dao.exists(id)) {
			return (SourceType) dao.select(id);
		}
		
		return NullSourceType.getInstance();
	}
	
}
