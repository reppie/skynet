package toctep.skynet.backend.dal.domain;

public class BoundingBox {

	private BoundingBoxType boundingBoxType;
	private String coordinates;
	
	public BoundingBox(BoundingBoxType boundingBoxType, String coordinates) {
		this.boundingBoxType = boundingBoxType;
		this.coordinates = coordinates;
	}
	
}
