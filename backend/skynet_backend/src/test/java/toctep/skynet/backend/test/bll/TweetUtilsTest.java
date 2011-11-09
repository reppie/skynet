package toctep.skynet.backend.test.bll;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import toctep.skynet.backend.bll.TweetUtils;
import toctep.skynet.backend.test.SkynetTest;

public class TweetUtilsTest extends SkynetTest {
	
	@Test
	public void testLocation() {
		assertTrue(TweetUtils.isDutchLocation("nederland"));
		assertTrue(TweetUtils.isDutchLocation("Nederland"));
		assertTrue(TweetUtils.isDutchLocation("netherlands"));
		assertTrue(TweetUtils.isDutchLocation("netherland"));
		assertTrue(!TweetUtils.isDutchLocation("test"));
	}
	
	@Test
	public void testLanguage() {
		assertTrue(TweetUtils.isDutchLanguage("dit is een nederlandse zin", "nl"));
		assertTrue(TweetUtils.isDutchLanguage("dit is een nederlandse zin", "en"));
		assertTrue(TweetUtils.isDutchLanguage("gutentag", "nl"));
		assertTrue(TweetUtils.isDutchLanguage("gutentag", "NL"));
		assertFalse(TweetUtils.isDutchLanguage("gutentag", "en"));
	}
}
