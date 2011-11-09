package toctep.skynet.backend.dal.domain.place;

import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;

public class PlaceType extends Domain<Integer> implements IPlaceType {

	private String text = "";
	
	public PlaceType() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getPlaceTypeDao());
	}
	
	@Override
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public static IPlaceType select(Integer id) {
		PlaceTypeDao dao = DaoFacadeImpl.getInstance().getPlaceTypeDao();
		
		if (dao.exists(id)) {
			return (PlaceType) dao.select(id);
		}
		
		return NullPlaceType.getInstance();
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getPlaceTypeDao().count();
	}
	
	public static boolean exists(PlaceType placeType) {
		return DaoFacadeImpl.getInstance().getPlaceTypeDao().exists(placeType);
	}
	
}
