from datetime import datetime, timedelta
from django.test import TestCase
from skynet_frontend.twitter.models import Tweet, Keyword, User

class TweetTest(TestCase):
    def setUp(self):
        self.id = 1337l
        self.text = "body of the tweet"
        self.created_at = datetime.now() 
        self.user = User(name="username")
        self.tweet = Tweet(id=self.id, text=self.text, created_at=self.created_at, user=self.user)
    
    def test_creation(self):
        self.assertTrue(self.tweet)
        self.assertEquals(self.tweet.id, self.id)
        self.assertEquals(self.tweet.text, self.text)
        self.assertEquals(self.tweet.created_at, self.created_at)
        self.assertEquals(self.tweet.user, self.user)

    def test_indexing(self):
        self.tweet.save()
        tweetIndices = Keyword.objects.filter(keyword="body")
        self.assertEquals(len(tweetIndices), 1)
        tweetIndices = Keyword.objects.all()
        self.assertEquals(len(tweetIndices), 4)
        
class TweetIndexTest(TestCase):
    def test_get_keyword_cloud_no_data(self):
        self.assertFalse(Keyword.get_keyword_cloud().items)
    
    def test_get_keyword_cloud(self):
        id = 1337l
        text = "keyword keyword keyword keyword singlekeyword"
        created_at = datetime.now()
        user = User(name="username")
        tweet = Tweet(id=id, text=text, created_at=created_at, user=user)
        tweet.save()
        self.assertTrue(Keyword.get_keyword_cloud().items[0])
        
    def test_get_all_since_no_data(self):
        yesterday = datetime.now() - timedelta(days=1)
        self.assertFalse(Keyword.get_all_since(yesterday))
        
    def test_get_all_since(self):
        user = User(name="username")
        recent_text = "recenttweet"
        recent_tweet = Tweet(text=recent_text, id=1337l, created_at=datetime.now(), user=user)
        recent_tweet.save()
        
        long_ago = datetime.now() - timedelta(days = 100)
        really_old_tweet = Tweet(text="oldtweet", id=1338l, created_at=long_ago, user=user)
        really_old_tweet.save()
        
        yesterday = datetime.now() - timedelta(days = 1)
        recent_indexes = Keyword.get_all_since(yesterday)
        
        self.assertEquals(recent_indexes.count(), 1)
        self.assertEquals(recent_indexes[0]['keyword'], recent_text)