package toctep.skynet.backend.dal.domain.boundingbox;


public class NullBoundingBox implements IBoundingBox {

	private static NullBoundingBox instance;
	
	public static NullBoundingBox getInstance() {
		if (instance == null) {
			instance = new NullBoundingBox();
		}
		return instance;
	}
	
	private NullBoundingBox() { }	
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getCoordinates() {
		return "";
	}

	@Override
	public IBoundingBoxType getType() {
		return NullBoundingBoxType.getInstance();
	}
	
}
