package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IGeo extends IDomain<Long> {

	IGeoType getType();
	String getCoordinates();
	
}
