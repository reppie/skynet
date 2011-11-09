package toctep.skynet.backend.dal.domain.sourcetype;

import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class SourceType extends Domain<Integer> implements ISourceType {

	private String text = "";

	public SourceType() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getSourceTypeDao());
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public static ISourceType select(Integer id) {
		SourceTypeDao dao = DaoFacadeImpl.getInstance().getSourceTypeDao();
		
		if (dao.exists(id)) {
			return (SourceType) dao.select(id);
		}
		
		return NullSourceType.getInstance();
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getSourceTypeDao().count();
	}
	
	public static boolean exists(SourceType sourceType) {
		return DaoFacadeImpl.getInstance().getSourceTypeDao().exists(sourceType);
	}
	
}
