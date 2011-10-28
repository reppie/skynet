from datetime import datetime, timedelta

from django.test import TestCase

from skynet_frontend.twitter.models import Keyword, User, Tweet
from skynet_frontend.keywordcloud.models import KeywordCloud

class CloudMapTest(TestCase):
    def setUp(self):
        text = "keyword singlekeyword"
        twitter_id = 1337
        created_at = datetime.now()
        user = User(name="username")
        tweet = Tweet(text=text, twitter_id=twitter_id, created_at=created_at, user=user)
        tweet.save()
        
        text = "keyword"
        tweet = Tweet(text=text, twitter_id=twitter_id, created_at=created_at, user=user)
        tweet.save()
        
        text = "keyword"
        tweet = Tweet(text=text, twitter_id=twitter_id, created_at=created_at, user=user)
        tweet.save()
        
        text = "keyword"
        tweet = Tweet(text=text, twitter_id=twitter_id, created_at=created_at, user=user)
        tweet.save()
        
    def test_creation(self):
        min_font_size = 14
        max_font_size = 30
        
        smallest = 1
        spread = 3
        
        step = (max_font_size - min_font_size) / spread
        
        query_set = Keyword.get_all_since(datetime.now() - timedelta(days = 1))
        cloud = KeywordCloud(query_set, min_font_size, max_font_size)
        
        self.assertEquals(cloud.items[0].font_size, min_font_size + (4 - smallest) * step)
        self.assertEquals(cloud.items[1].font_size, min_font_size + (1 - smallest) * step)