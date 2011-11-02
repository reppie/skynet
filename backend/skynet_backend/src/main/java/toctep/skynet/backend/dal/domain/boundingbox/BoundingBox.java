package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class BoundingBox extends Domain<Long> implements IBoundingBox {
	
	private IBoundingBoxType type 	= new NullBoundingBoxType();
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
}
