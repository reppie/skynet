package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.place.Place;

public class PlaceDaoImpl extends PlaceDao {

	@Override
	public void insert(Domain<String> domain) {
		Place place = (Place) domain;
		
		String query = 
			"INSERT INTO " + tableName + 
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
		
		String query = "SELECT * FROM " + tableName + " WHERE id=?";
		
		Param[] params = new Param[] {
			new Param(id, Types.VARCHAR)
		};
		
		ResultSet rs = MySqlUtil.getInstance().select(query, params);
		
		place.setId(id);
		try {
			place.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return place;
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
