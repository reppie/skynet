from django.db import models
from django.db.models import Count
from skynet_frontend.settings import TWITTER

class Hashtag(models.Model):
    text = models.CharField(max_length=139)

class Country(models.Model):
    code = models.CharField(max_length=2)
    text = models.CharField(max_length=255)
    
class PlaceType(models.Model):
    text = models.CharField(max_length=10)

class BoundingBoxType(models.Model):
    text = models.CharField(max_length=10)

class BoundingBox(models.Model):
    bounding_box_type = models.ForeignKey(BoundingBoxType)
    coordinates = models.TextField(null=True)

class Language(models.Model):
    text = models.CharField(max_length=2)

class SourceType(models.Model):
    text = models.CharField(max_length=10)

class TimeZone(models.Model):
    utc_offset = models.IntegerField()
    time_zone = models.CharField(max_length=255)

class Place(models.Model):
    twitter_id = models.BigIntegerField()
    place_type = models.ForeignKey(PlaceType)
    bounding_box = models.ForeignKey(BoundingBox)
    name = models.CharField(max_length=255)
    url = models.CharField(max_length=255)
    full_name = models.CharField(max_length=255)
    country = models.ForeignKey(Country)
    street_address = models.CharField(max_length=255)
    locality = models.CharField(max_length=255, null=True)
    region = models.CharField(max_length=255, null=True)
    iso3 = models.CharField(max_length=255, null=True)
    postal_code = models.CharField(max_length=255, null=True)
    phone = models.CharField(max_length=255, null=True)
    twitter = models.CharField(max_length=255, null=True)
    url = models.CharField(max_length=255, null=True)
    appid = models.CharField(max_length=255, null=True)

class User(models.Model):
    twitter_id = models.BigIntegerField()
    place = models.ForeignKey(Place)
    default_profile = models.BooleanField()
    statuses_count = models.IntegerField()
    profile_background_tile = models.BooleanField()
    language = models.ForeignKey(Language)
    profile_link_color = models.CharField(max_length=255)
    following = models.IntegerField()
    favourites_count = models.BigIntegerField()
    protected = models.BooleanField()
    profile_text_color = models.CharField(max_length=255)
    verified = models.BooleanField()
    contributors_enabled = models.BooleanField()
    description = models.CharField(max_length=160)
    name = models.CharField(max_length=255)
    profile_sidebar_border_color = models.CharField(max_length=255)
    profile_background_color = models.CharField(max_length=255)
    created_at = models.DateTimeField()
    default_profile_image = models.BooleanField()
    followers_count = models.IntegerField()
    profile_image_url = models.CharField(max_length=255)
    geo_enabled = models.BooleanField()
    profile_background_image_url = models.CharField(max_length=255, null=True)
    profile_background_image_url_https = models.CharField(max_length=255, null=True)
    follow_request_sent = models.BooleanField()
    url = models.CharField(max_length=255, null=True)
    time_zone = models.ForeignKey(TimeZone)
    notifications = models.IntegerField()
    profile_use_background_image = models.BooleanField()
    friends_count = models.IntegerField()
    profile_sidebar_fill_color = models.CharField(max_length=255)
    screen_name = models.CharField(max_length=255)
    profile_image_url = models.CharField(max_length=255)
    show_all_inline_media = models.BooleanField()
    is_translator = models.BooleanField()
    listed_count = models.IntegerField()

class Url(models.Model):
    text = models.CharField(max_length=255);

class Tweet(models.Model):
    text = models.CharField(max_length=140)
    geo = models.CharField(max_length=255, null=True) #@TODO: Find out what kind of field should be used here
    truncated = models.BooleanField()
    twitter_id = models.BigIntegerField()
    source_type = models.ForeignKey(SourceType)
    favorited = models.BooleanField()
    in_reply_to_tweet_twitter_id = models.BigIntegerField(null=True)
    in_reply_to_user_twitter_id = models.BigIntegerField(null=True)
    retweet_count = models.IntegerField()
    created_at = models.DateTimeField()
    place = models.ForeignKey(Place)
    user = models.ForeignKey(User)
    coordinates = models.TextField(null=True)
    urls = models.ManyToManyField(Url, verbose_name="list of URLs")
    hashtags = models.ManyToManyField(Hashtag, verbose_name="List of hashtags")
    
    def save(self, *args, **kwargs):
        super(Tweet, self).save(*args, **kwargs)
        keywords = self.text.split()
        for keyword in keywords:
            TweetIndex(keyword = keyword, tweet = self).save()
    
    def __unicode__(self):
        return "@" + self.user.name + ": " + self.text

class TweetMention(models.Model):
    tweet = models.ForeignKey(Tweet)
    user_twitter_id = models.BigIntegerField()
    
    class Meta:
        db_table = "twitter_tweet_mentions"

class TweetContributor(models.Model):
    tweet = models.ForeignKey(Tweet)
    user_twitter_id = models.BigIntegerField()
    
    class Meta:
        db_table = "twitter_tweet_contributors"

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
