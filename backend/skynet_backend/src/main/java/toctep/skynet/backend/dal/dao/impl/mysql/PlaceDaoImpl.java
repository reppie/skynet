package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.Types;
import java.util.Map;

import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.boundingbox.BoundingBox;
import toctep.skynet.backend.dal.domain.country.Country;
import toctep.skynet.backend.dal.domain.place.Place;
import toctep.skynet.backend.dal.domain.place.PlaceType;
import toctep.skynet.backend.dal.domain.url.Url;

public class PlaceDaoImpl extends PlaceDao {

	@Override
	public void insert(Domain<String> domain) {
		Place place = (Place) domain;
		
		String query = 
			"INSERT INTO " + TABLE_NAME + 
				"(id, place_type_id, bounding_box_id, name, url_id, full_name, country_id, street_address, locality, region, iso3, postal_code, phone, twitter, appid) " +
			"VALUES" +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Param[] params = new Param[] {
			new Param(place.getId(), Types.VARCHAR),
			new Param(place.getType().getId(), Types.BIGINT),
			new Param(place.getBoundingBox().getId(), Types.BIGINT),
			new Param(place.getName(), Types.VARCHAR),
			new Param(place.getUrl().getId(), Types.VARCHAR),
			new Param(place.getFullName(), Types.VARCHAR),
			new Param(place.getCountry().getId(), Types.VARCHAR),
			new Param(place.getStreetAddress(), Types.VARCHAR),
			new Param(place.getLocality(), Types.VARCHAR),
			new Param(place.getRegion(), Types.VARCHAR),
			new Param(place.getIso3(), Types.VARCHAR),
			new Param(place.getPostalCode(), Types.VARCHAR),
			new Param(place.getPhone(), Types.VARCHAR),
			new Param(place.getTwitter(), Types.VARCHAR),
			new Param(place.getAppId(), Types.VARCHAR)
		};
			
		MySqlUtil.getInstance().insert(query, params);
	}

	@Override
	public Place select(String id) {
		Place place = new Place();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.VARCHAR)
		};
		
		Map<String, Object> row = MySqlUtil.getInstance().selectRow(query, params);
		
		place.setId(id);
		place.setType(PlaceType.select((Integer) row.get("place_type_id")));
		place.setBoundingBox(BoundingBox.select((Integer) row.get("bounding_box_id")));
		place.setName((String) row.get("name"));
		place.setUrl(Url.select((String) row.get("url_id")));
		place.setFullName((String) row.get("full_name"));
		place.setCountry(Country.select((String) row.get("country_id")));
		place.setStreetAddress((String) row.get("street_address"));
		place.setLocality((String) row.get("locality"));
		place.setRegion((String) row.get("region"));
		place.setIso3((String) row.get("iso3"));
		place.setPostalCode((String) row.get("postal_code"));
		place.setPhone((String) row.get("phone"));
		place.setTwitter((String) row.get("twitter"));
		place.setAppId((String) row.get("appid"));
		
		return place;
	}

	@Override
	public void delete(Domain<String> domain) {
		Place place = (Place) domain;
		MySqlUtil.getInstance().delete(
			"DELETE FROM " + TABLE_NAME + " WHERE id=?",
			new Param[] { new Param(place.getId(), Types.VARCHAR) }
		);
	}

	@Override
	public boolean exists(Domain<String> domain) {
		Place place = (Place) domain;
		
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(place.getId(), Types.VARCHAR));
	}
	
	@Override
	public boolean exists(String id) {
		return MySqlUtil.getInstance().exists(TABLE_NAME, "id", new Param(id, Types.VARCHAR));
	}

	@Override
	public int count() {
		return MySqlUtil.getInstance().count(TABLE_NAME);
	}

}
