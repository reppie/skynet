package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IBoundingBox extends IDomain<Long>
{
	public IBoundingBoxType getType();
	public String getCoordinates();		

}