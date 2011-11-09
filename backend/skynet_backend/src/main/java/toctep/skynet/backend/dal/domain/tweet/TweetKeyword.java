package toctep.skynet.backend.dal.domain.tweet;

import java.util.List;

import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.dao.impl.mysql.DaoFacadeImpl;
import toctep.skynet.backend.dal.domain.Domain;
import toctep.skynet.backend.dal.domain.keyword.IKeyword;

public class TweetKeyword extends Domain<Integer> {
	
	private ITweet tweet;
	private String tweetKeywordValue;
	private IKeyword keyword;
	
	public TweetKeyword() {
		super();
		
		setDao(DaoFacadeImpl.getInstance().getTweetKeywordDao());
	}
	
	public ITweet getTweet() {
		return tweet;
	}
	
	public void setTweet(ITweet tweet) {
		this.tweet = tweet;
	}
	
	public String getTweetKeywordValue() {
		return tweetKeywordValue;
	}
	
	public void setTweetKeywordValue(String tweetKeywordValue) {
		this.tweetKeywordValue = tweetKeywordValue;
	}
	
	public IKeyword getKeyword() {
		return keyword;
	}
	
	public void setKeyword(IKeyword keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public void save() {
		if (((Tweet) tweet).isDirty()) {
			((Tweet) tweet).save();
		}
		
		keyword.save();
		
		super.save();
	}
	
	public static TweetKeyword select(Integer id) {
		TweetKeywordDao dao = DaoFacadeImpl.getInstance().getTweetKeywordDao();
		return (TweetKeyword) dao.select(id);
	}
	
	public static List<TweetKeyword> select(Tweet tweet) {
		TweetKeywordDao dao = DaoFacadeImpl.getInstance().getTweetKeywordDao();
		return dao.select(tweet);
	}
	
	public static int count() {
		return DaoFacadeImpl.getInstance().getTweetKeywordDao().count();
	}
	
	public static boolean exists(Integer id) {
		return DaoFacadeImpl.getInstance().getTweetKeywordDao().exists(id);
	}
	
	public static boolean exists(TweetKeyword tweetKeyword) {
		return DaoFacadeImpl.getInstance().getTweetKeywordDao().exists(tweetKeyword);
	}
	
}
