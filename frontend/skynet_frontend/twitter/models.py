from django.db import models

class Tweet(models.Model):
    body = models.CharField(max_length=140)
    datetime = models.DateTimeField()
    twitter_id = models.BigIntegerField()
    username = models.CharField(max_length=15)
    
class TweetIndex(models.Model):
    keyword = models.CharField(max_length=140)
    tweet = models.ForeignKey(Tweet)