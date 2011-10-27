from datetime import datetime

from django.test import TestCase
from django.db.models import Count

from skynet_frontend.twitter.models import Keyword, User, Tweet
from skynet_frontend.keywordcloud.models import KeywordCloud

class CloudMapTest(TestCase):
    def setUp(self):
        self.text = "keyword keyword keyword keyword singlekeyword"
        self.twitter_id = 1337
        self.created_at = datetime.now()
        self.user = User(name="username")
        self.tweet = Tweet(text=self.text, twitter_id=self.twitter_id, created_at=self.created_at, user=self.user)
        self.tweet.save()
        
    def test_creation(self):
        min_font_size = 14
        max_font_size = 30
        
        smallest = 1
        spread = 3
        
        step = (max_font_size - min_font_size) / spread
        
        query_set = Keyword.objects.values('keyword').annotate(count=Count('keyword'))
        cloud = KeywordCloud(query_set, min_font_size, max_font_size)
        
        self.assertEquals(cloud.items[0].font_size, min_font_size + (4 - smallest) * step)
        self.assertEquals(cloud.items[1].font_size, min_font_size + (1 - smallest) * step)