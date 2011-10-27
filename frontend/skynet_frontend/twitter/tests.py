from datetime import datetime
from django.test import TestCase
from skynet_frontend.twitter.models import Tweet, TweetIndex, User

class TweetTest(TestCase):
    def setUp(self):
        self.text = "body of the tweet"
        self.twitter_id = 1337
        self.created_at = datetime.now() 
        self.user = User(name="username")
        self.tweet = Tweet(text=self.text, twitter_id=self.twitter_id, created_at=self.created_at, user=self.user)
    
    def test_creation(self):
        self.assertTrue(self.tweet)
        self.assertEquals(self.tweet.text, self.text)
        self.assertEquals(self.tweet.twitter_id, self.twitter_id)
        self.assertEquals(self.tweet.created_at, self.created_at)
        self.assertEquals(self.tweet.user, self.user)

    def test_indexing(self):
        self.tweet.save()
        tweetIndices = TweetIndex.objects.filter(keyword="body")
        self.assertEquals(len(tweetIndices), 1)
        tweetIndices = TweetIndex.objects.all()
        self.assertEquals(len(tweetIndices), 4)
        
class TweetIndexTest(TestCase):
    def test_get_keyword_cloud(self):
        text = "keyword keyword keyword keyword singlekeyword"
        twitter_id = 1337
        created_at = datetime.now()
        user = User(name="username")
        tweet = Tweet(text=text, twitter_id=twitter_id, created_at=created_at, user=user)
        tweet.save()
        self.assertTrue(TweetIndex().get_keyword_cloud().items[0])
        
    def test_get_keyword_cloud_no_data(self):
        self.assertFalse(TweetIndex().get_keyword_cloud().items)

        