package toctep.skynet.backend.dal.domain.country;

import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class Country extends Domain<String> implements ICountry {

	private String text = "";

	public Country() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getCountryDao());
	}
	
	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static ICountry select(String id) {
		CountryDao dao = DaoFacadeImpl.getInstance().getCountryDao();
		
		if (dao.exists(id)) {
			return (Country) dao.select(id);
		}
		
		return NullCountry.getInstance();
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getCountryDao().count();
	}
	
	public static boolean exists(Country country) {
		return DaoFacadeImpl.getInstance().getCountryDao().exists(country);
	}
	
}
