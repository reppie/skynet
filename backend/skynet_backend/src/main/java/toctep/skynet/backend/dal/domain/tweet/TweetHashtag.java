package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.hashtag.Hashtag;
import toctep.skynet.backend.dal.domain.hashtag.IHashtag;

public class TweetHashtag extends Domain<Integer> {
	
	private ITweet tweet;
	private IHashtag hashtag;
	
	public TweetHashtag() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetHashtagDao());
	}
	
	public ITweet getTweet() {
		return tweet;
	}

	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}

	public IHashtag getHashtag() {
		return hashtag;
	}

	public void setHashtag(IHashtag hashtag) {
		this.hashtag = hashtag;
	}
	
	@Override
	public void save() {
		
		if (tweet instanceof Tweet && ((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
			((Tweet) this.tweet).setId(((Tweet) tweet).getId());
		}
		
		if (hashtag instanceof Hashtag) {
			((Hashtag) hashtag).save();
			((Hashtag) this.hashtag).setId(((Hashtag) hashtag).getId());
		}
		
		super.save();
	}	
	
	public static TweetHashtag select(Integer id) {
		TweetHashtagDao dao = DaoFacadeImpl.getInstance().getTweetHashtagDao();
		
		if (dao.exists(id)) {
			return (TweetHashtag) dao.select(id);
		}
		
		return null;
	}
	
	public static List<TweetHashtag> select(Tweet tweet) {
		TweetHashtagDao dao = DaoFacadeImpl.getInstance().getTweetHashtagDao();
		return dao.select(tweet);
	}
	
}
