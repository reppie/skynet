package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBoxType extends Domain<Long> implements IBoundingBoxType {

	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getBoundingBoxTypeDao();		
	}
	
	public static IBoundingBoxType select(Long id) {
		BoundingBoxTypeDao dao = DaoFacadeImpl.getInstance().getBoundingBoxTypeDao();
		
		if (dao.exists(id)) {
			return (BoundingBoxType) dao.select(id);
		}
		
		return new NullBoundingBoxType();
	}
	
}
