package toctep.skynet.backend.dal.domain;

public class GeoType extends DomainLongPk {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setDao() {
		dao = daoFacade.getGeoTypeDao();	
	}	
}
