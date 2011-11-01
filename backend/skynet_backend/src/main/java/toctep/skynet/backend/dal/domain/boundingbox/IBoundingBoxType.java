package toctep.skynet.backend.dal.domain.boundingbox;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IBoundingBoxType<T> extends IDomain<Long> {
	public String getText();
}
