from django.db import models

class Tweet(models.Model):
    body = models.CharField(max_length=140)
    datetime = models.DateTimeField(auto_now_add=True)
    twitter_id = models.BigIntegerField()
    username = models.CharField(max_length=15)
    
    def save(self, *args, **kwargs):
        super(Tweet, self).save(*args, **kwargs)
        keywords = self.body.split()
        for keyword in keywords:
            TweetIndex(keyword = keyword, tweet = self).save()
    
    def __unicode__(self):
        return "@" + self.username + ": " + self.body
    
class TweetIndex(models.Model):
    keyword = models.CharField(max_length=140)
    tweet = models.ForeignKey(Tweet)

    def __unicode__(self):
        return self.keyword