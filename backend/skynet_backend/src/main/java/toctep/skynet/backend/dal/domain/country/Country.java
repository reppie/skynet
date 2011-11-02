package toctep.skynet.backend.dal.domain.country;

import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Country extends Domain<String> implements ICountry {

	private String text = "";

	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getCountryDao();		
	}
	
	public static ICountry select(String id) {
		CountryDao dao = DaoFacadeImpl.getInstance().getCountryDao();
		
		if (dao.exists(id)) {
			return (Country) dao.select(id);
		}
		
		return NullCountry.getInstance();
	}
	
}
