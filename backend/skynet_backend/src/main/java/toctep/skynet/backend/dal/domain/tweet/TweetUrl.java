package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.Url;

public class TweetUrl extends Domain<Long> {
	
	private ITweet tweet;
	private IUrl url;

	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public IUrl getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
	}
	
	public static Object select(Long id) {
		//TODO
		return null;
	}
	
}
