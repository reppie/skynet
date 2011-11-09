package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.IUrl;

public class TweetUrl extends Domain<Integer> {
	
	private ITweet tweet;
	private IUrl url;

	public TweetUrl() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetUrlDao());
	}
	
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
	public void save() {
		
		if (((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
		}
		
		url.save();
		
		super.save();
	}	
	
	public static List<TweetUrl> select(Tweet tweet) {
		TweetUrlDao dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
		return dao.select(tweet);
	}
	
}
