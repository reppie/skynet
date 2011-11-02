package toctep.skynet.backend.dal.domain.tweet;

public class NullKeyword implements IKeyword {

	@Override
	public Long getId() {
		return null;
	}
	
	@Override
	public String getKeyword() {
		return "";
	}

}
