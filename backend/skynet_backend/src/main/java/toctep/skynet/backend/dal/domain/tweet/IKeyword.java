package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.domain.IDomain;

public interface IKeyword extends IDomain<Long> {

	String getKeyword();
	
}
