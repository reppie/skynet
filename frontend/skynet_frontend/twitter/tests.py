import datetime
from django.test import TestCase
from skynet_frontend.twitter.models import Tweet, TweetIndex, User

class TweetTest(TestCase):
    def setUp(self):
        self.text = "body of the tweet"
        self.twitter_id = 1337
        self.created_at = datetime.datetime.now() 
        self.user = User(name="username")
        self.tweet = Tweet(text=self.text, twitter_id=self.twitter_id, created_at=self.created_at, user=self.user)
    
    def testCreation(self):
        self.assertTrue(self.tweet)
        self.assertEquals(self.tweet.text, self.text)
        self.assertEquals(self.tweet.twitter_id, self.twitter_id)
        self.assertEquals(self.tweet.created_at, self.created_at)
        self.assertEquals(self.tweet.user, self.user)

    def testSave(self):
        self.tweet.save()
        tweetIndices = TweetIndex.objects.filter(keyword="body")
        self.assertEquals(len(tweetIndices), 1)
        tweetIndices = TweetIndex.objects.all()
        self.assertEquals(len(tweetIndices), 4)

class TweetIndexTest(TestCase):
    def setUp(self):
        self.text = "keyword keyword keyword keyword singlekeyword"
        self.twitter_id = 1337
        self.created_at = datetime.datetime.now()
        self.user = User(name="username")
        self.tweet = Tweet(text=self.text, twitter_id=self.twitter_id, created_at=self.created_at, user=self.user)
        self.tweet.save()
    
    def testCloudData(self):
        min_font_size = 14
        max_font_size = 30
        
        smallest = 1
        spread = 3
        
        step = (max_font_size - min_font_size) / spread
        
        cloud = TweetIndex().getCloudMap()
        
        self.assertEquals(cloud[0].count, min_font_size + (4 - smallest) * step)
        self.assertEquals(cloud[1].count, min_font_size + (1 - smallest) * step)
        
        