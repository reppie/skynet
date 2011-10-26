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
    coordinates = models.TextField()

class Language(models.Model):
    text = models.CharField(max_length=2)

class SourceType(models.Model):
    text = models.CharField(max_length=10)

class TimeZone(models.Model):
    utc_offset = models.IntegerField()
    time_zone = models.CharField(max_length=255)

class Place(models.Model):
    twitter_id = models.BigIntegerField(null=True)
    place_type = models.ForeignKey(PlaceType, null=True)
    bounding_box = models.ForeignKey(BoundingBox, null=True)
    name = models.CharField(max_length=255)
    url = models.CharField(max_length=255, null=True)
    full_name = models.CharField(max_length=255, null=True)
    country = models.ForeignKey(Country, null=True)
    street_address = models.CharField(max_length=255, null=True)
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
    place = models.ForeignKey(Place, null=True)
    default_profile = models.BooleanField(default=True)
    statuses_count = models.IntegerField(default=0)
    profile_background_tile = models.BooleanField()
    language = models.ForeignKey(Language, null=True)
    profile_link_color = models.CharField(max_length=255, null=True)
    following = models.IntegerField(default=0)
    favourites_count = models.BigIntegerField(default=0)
    protected = models.BooleanField(default=False)
    profile_text_color = models.CharField(max_length=255, null=True)
    verified = models.BooleanField(default=False)
    contributors_enabled = models.BooleanField(default=False)
    description = models.CharField(max_length=160, null=True)
    name = models.CharField(max_length=255, default="")
    profile_sidebar_border_color = models.CharField(max_length=255, null=True)
    profile_background_color = models.CharField(max_length=255, null=True)
    created_at = models.DateTimeField(null=True)
    default_profile_image = models.BooleanField(default=False)
    followers_count = models.IntegerField(default=0)
    profile_image_url = models.CharField(max_length=255, null=True)
    geo_enabled = models.BooleanField(default=False)
    profile_background_image_url = models.CharField(max_length=255, null=True)
    profile_background_image_url_https = models.CharField(max_length=255, null=True)
    follow_request_sent = models.BooleanField(default=False)
    url = models.CharField(max_length=255, null=True)
    time_zone = models.ForeignKey(TimeZone, null=True)
    notifications = models.IntegerField(default=0)
    profile_use_background_image = models.BooleanField(default=False)
    friends_count = models.IntegerField(default=0)
    profile_sidebar_fill_color = models.CharField(max_length=255, null=True)
    screen_name = models.CharField(max_length=255, null=True)
    profile_image_url = models.CharField(max_length=255, null=True)
    show_all_inline_media = models.BooleanField(default=False)
    is_translator = models.BooleanField(default=False)
    listed_count = models.IntegerField(default=0)

class Url(models.Model):
    text = models.CharField(max_length=255);

class Tweet(models.Model):
    text = models.CharField(max_length=140)
    geo = models.CharField(max_length=255, null=True) #@TODO: Find out what kind of field should be used here, oftewel WTF!?
    truncated = models.BooleanField(default=False)
    twitter_id = models.BigIntegerField(null=True)
    source_type = models.ForeignKey(SourceType, null=True)
    favorited = models.BooleanField(default=False)
    in_reply_to_tweet_twitter_id = models.BigIntegerField(null=True)
    in_reply_to_user_twitter_id = models.BigIntegerField(null=True)
    retweet_count = models.IntegerField(default=0)
    created_at = models.DateTimeField(null=True)
    place = models.ForeignKey(Place, null=True)
    user = models.ForeignKey(User, null=True)
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
