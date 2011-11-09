package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
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
		if (((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
		}
		
		hashtag.save();
		
		super.save();
	}	
	
	public static List<TweetHashtag> select(Tweet tweet) {
		TweetHashtagDao dao = DaoFacadeImpl.getInstance().getTweetHashtagDao();
		return dao.select(tweet);
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getTweetHashtagDao().count();
	}
	
	public static boolean exists(TweetHashtag tweetHashtag) {
		return DaoFacadeImpl.getInstance().getTweetHashtagDao().exists(tweetHashtag);
	}
	
}
