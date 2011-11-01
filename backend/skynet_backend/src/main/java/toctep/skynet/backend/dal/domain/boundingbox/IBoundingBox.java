package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IBoundingBox extends IDomain<Long> {
	
	IBoundingBoxType getType();
	String getCoordinates();		

}
