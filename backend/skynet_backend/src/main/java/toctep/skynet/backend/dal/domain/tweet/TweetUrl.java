package toctep.skynet.backend.dal.domain.tweet;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.IUrl;

public class TweetUrl extends Domain<Integer> {
	
	private ITweet tweet;
	private IUrl url;

	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}

	public IUrl getUrl() {
		return url;
	}

	public void setUrl(IUrl url) {
		this.url = url;
	}

	@Override
	public void setDao() {
		dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
	}
	
	public static TweetUrl select(Integer id) {
		TweetUrlDao dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
		
		if (dao.exists(id)) {
			return (TweetUrl) dao.select(id);
		}
		
		return null;
	}
	
}
