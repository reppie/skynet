package toctep.skynet.backend.dal.domain.boundingbox;

public class NullBoundingBoxType implements IBoundingBoxType {

	private static NullBoundingBoxType instance;
	
	public static NullBoundingBoxType getInstance() {
		if (instance == null) {
			instance = new NullBoundingBoxType();
		}
		return instance;
	}
	
	private NullBoundingBoxType() { }	
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public String getText() {
		return "";
	}
	
}
