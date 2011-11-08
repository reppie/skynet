package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBoxType extends Domain<Integer> implements IBoundingBoxType {

	private String text = "";

	public BoundingBoxType() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getBoundingBoxTypeDao());
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static IBoundingBoxType select(Integer id) {
		BoundingBoxTypeDao dao = DaoFacadeImpl.getInstance().getBoundingBoxTypeDao();
		
		if (dao.exists(id)) {
			return (BoundingBoxType) dao.select(id);
		}
		
		return NullBoundingBoxType.getInstance();
	}
	
}
