from datetime import datetime, timedelta

from django.test import TestCase

from skynet_frontend.twitter.models import Keyword, User, Tweet
from skynet_frontend.keywordcloud.models import KeywordCloud

from math import log

class CloudMapTest(TestCase):
    def setUp(self):
        id = 1337l
        text = "keyword"
        created_at = datetime.now()
        user = User(name="username")
        tweet = Tweet(id=id, text=text, created_at=created_at, user=user)
        tweet.save();
        
        text = "singlekeyword"
        tweet = Tweet(id=id, text=text, created_at=created_at, user=user)
        tweet.save()
        
        text = "keyword"
        tweet = Tweet(id=id, text=text, created_at=created_at, user=user)
        tweet.save()
        
        text = "keyword"
        tweet = Tweet(id=id, text=text, created_at=created_at, user=user)
        tweet.save()
        
    def test_creation(self):
        min_font_size = 15
        max_font_size = 30
        
        smallest = 1
        largest = 3
        
        step_smallest = (log(1)-log(smallest))/(log(largest)-log(smallest))
        step_largest = (log(3)-log(smallest))/(log(largest)-log(smallest))
        
        query_set = Keyword.get_all_since(datetime.now() - timedelta(days = 1))
        cloud = KeywordCloud(query_set, min_font_size, max_font_size)
        
        item_0_size = round(min_font_size + (max_font_size-min_font_size)*step_largest)/min_font_size*100
        item_1_size = round(min_font_size + (max_font_size-min_font_size)*step_smallest)/min_font_size*100
        
        self.assertEquals(cloud.items[0].font_scale, item_0_size)
        self.assertEquals(cloud.items[1].font_scale, item_1_size)