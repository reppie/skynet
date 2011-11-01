package toctep.skynet.backend.dal.dao.impl.mysql;

import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.url.Url;

public class PlaceDaoImpl extends PlaceDao {

	@Override
	public void insert(Domain<String> domain) {
		Place place = (Place) domain;
		
		String query = "INSERT INTO " + tableName +	" VALUES ("
		+ MySqlUtil.escape(place.getId()) + ", "
		+ ((PlaceType) place.getType()).getId() + ", "
		+ place.getBoundingBox().getId() + ", "
		+ MySqlUtil.escape(place.getName()) + ", "
		+ MySqlUtil.escape(((Url) place.getUrl()).getId()) + ", "
		+ MySqlUtil.escape(place.getFullName()) + ", "
		+ MySqlUtil.escape(((Country) place.getCountry()).getId()) + ", "
		+ MySqlUtil.escape(place.getStreetAddress()) + ", "
		+ MySqlUtil.escape(place.getLocality()) + ", "
		+ MySqlUtil.escape(place.getRegion()) + ", "
		+ MySqlUtil.escape(place.getIso3()) + ", "
		+ MySqlUtil.escape(place.getPostalCode()) + ", "
		+ MySqlUtil.escape(place.getPhone()) + ", "
		+ MySqlUtil.escape(place.getTwitter()) + ", "
		+ MySqlUtil.escape(place.getAppId()) + ")";
		
		MySqlUtil.getInstance().insert(query);
	}

	@Override
	public Place select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domain<String> domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Domain<String> domain) {
		Place place = (Place) domain;
		MySqlUtil.getInstance().delete("DELETE FROM " + tableName + " WHERE id = " + MySqlUtil.escape(place.getId()));
	}

	@Override
	public boolean exists(Domain<String> domain) {
		Place place = (Place) domain;
		return MySqlUtil.getInstance().exists(tableName, "id = " + MySqlUtil.escape(place.getId()));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(tableName);
	}

}
