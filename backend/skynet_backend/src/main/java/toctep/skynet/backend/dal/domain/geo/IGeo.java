package toctep.skynet.backend.dal.domain.geo;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IGeo extends IDomain<Integer> {

	IGeoType getType();
	String getCoordinates();
	
}
