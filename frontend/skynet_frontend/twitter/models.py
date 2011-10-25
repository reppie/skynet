from django.db import models
from django.db.models import Count
from skynet_frontend.settings import TWITTER

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

    def getCloudMap(self):
        query_set = TweetIndex.objects.values('keyword').annotate(count=Count('keyword'))
        keyword_map = {}
        for entry in query_set:
            keyword_map[entry['keyword']] = entry['count']

        largest = None
        smallest = None
        total_count = 0
        sum_count = 0
        for entry in query_set:
            count = entry['count']
            
            if(largest is None or count > largest):
                largest = count

            if(smallest is None or count < smallest):
                smallest = count
                
            total_count = total_count + 1
            sum_count = sum_count + count

        spread = largest - smallest
        if(spread < 1):
            spread = 1
            
        min_font_size = TWITTER['keywordcloud']['min_font_size']
        max_font_size = TWITTER['keywordcloud']['max_font_size']
        step = (max_font_size - min_font_size) / spread
        sizes = []
        for entry in query_set:
            count = min_font_size + (entry['count'] - smallest) * step
            t = TweetIndexCount(keyword=entry["keyword"], count=count)
            sizes.append(t)
            
        return sizes
            
    def __unicode__(self):
        return self.keyword
    
    
class TweetIndexCount(models.Model):
    class Meta:
        managed = False
    
    keyword = models.CharField(max_length=140)
    count = models.IntegerField()
    
    