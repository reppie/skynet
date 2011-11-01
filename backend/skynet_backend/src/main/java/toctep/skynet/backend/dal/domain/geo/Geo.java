package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.DomainLongPk;

public class Geo extends DomainLongPk {
	
	private GeoType type;
	private String coordinates;

	public GeoType getType() {
		return type;
	}

	public void setType(GeoType type) {
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
		dao = daoFacade.getGeoDao();
	}
	
	@Override
	public void save() {
		type.save();
		this.type.setId(type.getId());
		super.save();
	}		
	
}
