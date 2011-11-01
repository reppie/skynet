package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.Domain;

public class Geo extends Domain<Long> implements IGeo {
	
	private IGeoType type 		= new NullGeoType();
	private String coordinates	= "";

	public IGeoType getType() {
		return type;
	}

	public void setType(IGeoType type) {
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
		dao = getDaoFacade().getGeoDao();
	}
	
	@Override
	public void save() {
		if (type instanceof GeoType) {
			((GeoType) type).save();
			((GeoType) this.type).setId(((GeoType) type).getId());
		}
		
		super.save();
	}		
	
}
