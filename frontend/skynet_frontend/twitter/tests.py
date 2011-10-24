"""
This file demonstrates writing tests using the unittest module. These will pass
when you run "manage.py test".

Replace this with more appropriate tests for your application.eet
"""
from django.test import TestCase
from skynet_frontend.twitter.models import Tweet , TweetIndex
class TweetTest(TestCase):
    def setUp(self):
        self.body = "body of the tweet"
        self.twitter_id = 1337
        self.username = "user"
        self.tweet = Tweet(body=self.body, twitter_id=self.twitter_id, username=self.username)
    
    def testCreation(self):
        self.assertTrue(self.tweet)
        self.assertEquals(self.tweet.body, self.body)
        self.assertEquals(self.tweet.twitter_id, self.twitter_id)
        self.assertEquals(self.tweet.username, self.username)

    def testSave(self):
        self.tweet.save()
        tweetIndices = TweetIndex.objects.filter(keyword="body")
        self.assertEquals(len(tweetIndices), 1)
        tweetIndices = TweetIndex.objects.all()
        self.assertEquals(len(tweetIndices), 4)
        