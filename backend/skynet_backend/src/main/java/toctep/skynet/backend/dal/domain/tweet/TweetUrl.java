package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.url.IUrl;
import toctep.skynet.backend.dal.domain.url.Url;

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
		
		if (tweet instanceof Tweet && ((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
			((Tweet) this.tweet).setId(((Tweet) tweet).getId());
		}
		
		if (url instanceof Url) {
			((Url) url).save();
			((Url) this.url).setId(((Url) url).getId());
		}
		
		super.save();
	}	
	
	public static TweetUrl select(Integer id) {
		TweetUrlDao dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
		
		if (dao.exists(id)) {
			return (TweetUrl) dao.select(id);
		}
		
		return null;
	}
	
	public static List<TweetUrl> select(Tweet tweet) {
		TweetUrlDao dao = DaoFacadeImpl.getInstance().getTweetUrlDao();
		return dao.select(tweet);
	}
	
}
