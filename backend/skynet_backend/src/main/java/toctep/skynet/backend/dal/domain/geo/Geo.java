package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Geo extends Domain<Integer> implements IGeo {
	
	private IGeoType type 		= NullGeoType.getInstance();
	private String coordinates	= "";

	public Geo() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getGeoDao());
	}
	
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
	public void save() {
		type.save();
				
		super.save();
	}
	
	public static IGeo select(Integer id) {
		GeoDao dao = DaoFacadeImpl.getInstance().getGeoDao();
		
		if (dao.exists(id)) {
			return (Geo) dao.select(id);
		}
		
		return NullGeo.getInstance();
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getGeoDao().count();
	}
	
	public static boolean exists(Geo geo) {
		return DaoFacadeImpl.getInstance().getGeoDao().exists(geo);
	}
	
}
