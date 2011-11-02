package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBox extends Domain<Integer> implements IBoundingBox {
	
	private IBoundingBoxType type 	= NullBoundingBoxType.getInstance();
	private String coordinates		= "";
	
	public IBoundingBoxType getType() {
		return type;
	}

	public void setType(IBoundingBoxType type) {
		this.type = type;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getBoundingBoxDao();
	}
	
	@Override
	public void save() {
		if(type instanceof BoundingBoxType) {
			((BoundingBoxType) type).save();
			((BoundingBoxType) this.type).setId(((BoundingBoxType) type).getId());
		}
		
		super.save();
	}
	
	public static IBoundingBox select(Integer id) {
		BoundingBoxDao dao = DaoFacadeImpl.getInstance().getBoundingBoxDao();
		
		if (dao.exists(id)) {
			return (BoundingBox) dao.select(id);
		}
		
		return NullBoundingBox.getInstance();
	}
	
}
