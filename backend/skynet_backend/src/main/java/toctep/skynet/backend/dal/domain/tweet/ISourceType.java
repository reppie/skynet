package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.IDomain;

public interface ISourceType extends IDomain<Long> {

	public String getText();
	
}
