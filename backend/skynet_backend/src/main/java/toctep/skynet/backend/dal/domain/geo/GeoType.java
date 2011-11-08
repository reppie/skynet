package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class GeoType extends Domain<Integer> implements IGeoType {

	private String text = "";

	public GeoType() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getGeoTypeDao());
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static IGeoType select(Integer id) {
		GeoTypeDao dao = DaoFacadeImpl.getInstance().getGeoTypeDao();
		
		if (dao.exists(id)) {
			return (GeoType) dao.select(id);
		}
		
		return NullGeoType.getInstance();
	}
	
}
