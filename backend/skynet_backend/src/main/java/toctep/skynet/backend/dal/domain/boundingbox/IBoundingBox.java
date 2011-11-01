package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IBoundingBox<T> extends IDomain<T> {
	public IBoundingBoxType<T> getType();
	public String getCoordinates();		
}
