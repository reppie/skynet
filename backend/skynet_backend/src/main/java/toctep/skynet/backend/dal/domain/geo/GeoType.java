package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class GeoType extends Domain<Long> implements IGeoType {

	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getGeoTypeDao();	
	}
	
	public static IGeoType select(Long id) {
		GeoTypeDao dao = DaoFacadeImpl.getInstance().getGeoTypeDao();
		
		if (dao.exists(id)) {
			return (GeoType) dao.select(id);
		}
		
		return NullGeoType.getInstance();
	}
	
}
