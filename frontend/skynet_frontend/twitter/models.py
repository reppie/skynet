from django.db import models
from django.db.models import Count
from skynet_frontend.settings import TWITTER

class Hashtag(models.Model):
    text = models.CharField(max_length=139, blank=True, null=True)

class Country(models.Model):
    code = models.CharField(max_length=2, blank=True, null=True)
    text = models.CharField(max_length=255, blank=True, null=True)
    
class PlaceType(models.Model):
    text = models.CharField(max_length=10, blank=True, null=True)

class BoundingBoxType(models.Model):
    text = models.CharField(max_length=10, blank=True, null=True)

class BoundingBox(models.Model):
    bounding_box_type = models.ForeignKey(BoundingBoxType, blank=True, null=True)
    coordinates = models.TextField(blank=True, null=True)

class Language(models.Model):
    text = models.CharField(max_length=2, blank=True, null=True)

class SourceType(models.Model):
    text = models.CharField(max_length=10, blank=True, null=True)

class TimeZone(models.Model):
    utc_offset = models.IntegerField(blank=True, default=0)
    time_zone = models.CharField(max_length=255, blank=True, null=True)

class Place(models.Model):
    twitter_id = models.IntegerField(blank=True, default=0)
    place_type = models.ForeignKey(PlaceType, blank=True, null=True)
    bounding_box = models.ForeignKey(BoundingBox, blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    url = models.CharField(max_length=255, blank=True, null=True)
    full_name = models.CharField(max_length=255, blank=True, null=True)
    country = models.ForeignKey(Country, blank=True, null=True)
    street_address = models.CharField(max_length=255, blank=True, null=True)
    locality = models.CharField(max_length=255, blank=True, null=True)
    region = models.CharField(max_length=255, blank=True, null=True)
    iso3 = models.CharField(max_length=255, blank=True, null=True)
    postal_code = models.CharField(max_length=255, blank=True, null=True)
    phone = models.CharField(max_length=255, blank=True, null=True)
    twitter = models.CharField(max_length=255, blank=True, null=True)
    url = models.CharField(max_length=255, blank=True, null=True)
    appid = models.CharField(max_length=255, blank=True, null=True)

class User(models.Model):
    twitter_id = models.IntegerField(blank=True, default=0)
    place = models.ForeignKey(Place, blank=True, null=True)
    default_profile = models.BooleanField(blank=True)
    statuses_count = models.IntegerField(blank=True, default=0)
    profile_background_tile = models.BooleanField(blank=True)
    language = models.ForeignKey(Language, blank=True, null=True)
    profile_link_color = models.CharField(max_length=255, blank=True, null=True)
    following = models.IntegerField(blank=True, default=0)
    favourites_count = models.IntegerField(blank=True, default=0)
    protected = models.BooleanField(blank=True)
    profile_text_color = models.CharField(max_length=255, blank=True, null=True)
    verified = models.BooleanField(blank=True)
    contributors_enabled = models.BooleanField(blank=True)
    description = models.CharField(max_length=160, blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    profile_sidebar_border_color = models.CharField(max_length=255, blank=True, null=True)
    profile_background_color = models.CharField(max_length=255, blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    default_profile_image = models.BooleanField(blank=True)
    followers_count = models.IntegerField(blank=True, default=0)
    profile_image_url = models.CharField(max_length=255, blank=True, null=True)
    geo_enabled = models.BooleanField(blank=True)
    profile_background_image_url = models.CharField(max_length=255, blank=True, null=True)
    profile_background_image_url_https = models.CharField(max_length=255, blank=True, null=True)
    follow_request_sent = models.BooleanField(blank=True)
    url = models.CharField(max_length=255, blank=True, null=True)
    time_zone = models.ForeignKey(TimeZone, blank=True, null=True)
    notifications = models.IntegerField(blank=True, default=0)
    profile_use_background_image = models.BooleanField(blank=True)
    friends_count = models.IntegerField(blank=True, default=0)
    profile_sidebar_fill_color = models.CharField(max_length=255, blank=True, null=True)
    screen_name = models.CharField(max_length=255, blank=True, null=True)
    profile_image_url = models.CharField(max_length=255, blank=True, null=True)
    show_all_inline_media = models.BooleanField(blank=True)
    is_translator = models.BooleanField(blank=True)
    listed_count = models.IntegerField(blank=True, default=0)

class Url(models.Model):
    text = models.CharField(max_length=255, blank=True, null=True);

class Tweet(models.Model):
    text = models.CharField(max_length=140, blank=True, null=True)
    geo = models.CharField(max_length=255, blank=True, null=True) #@TODO: Find out what kind of field should be used here, oftewel WTF!?
    truncated = models.BooleanField(blank=True)
    twitter_id = models.IntegerField(blank=True, default=0)
    source_type = models.ForeignKey(SourceType, blank=True, null=True)
    favorited = models.BooleanField(blank=True)
    in_reply_to_tweet_twitter_id = models.IntegerField(blank=True, default=0)
    in_reply_to_user_twitter_id = models.IntegerField(blank=True, default=0)
    retweet_count = models.IntegerField(blank=True, default=0)
    created_at = models.DateTimeField(blank=True, null=True)
    place = models.ForeignKey(Place, blank=True, null=True)
    user = models.ForeignKey(User, blank=True, null=True)
    coordinates = models.TextField(blank=True, null=True)
    urls = models.ManyToManyField(Url, verbose_name="list of URLs")
    hashtags = models.ManyToManyField(Hashtag, verbose_name="List of hashtags")
    
    def save(self, *args, **kwargs):
        super(Tweet, self).save(*args, **kwargs)
        keywords = self.text.split()
        for keyword in keywords:
            TweetIndex(keyword = keyword, tweet = self).save()
    
    def __unicode__(self):
        return "@tweeter: " + self.text

class TweetMention(models.Model):
    tweet = models.ForeignKey(Tweet)
    user_twitter_id = models.IntegerField()
    
    class Meta:
        db_table = "twitter_tweet_mentions";

class TweetContributor(models.Model):
    tweet = models.ForeignKey(Tweet)
    user_twitter_id = models.IntegerField()

    class Meta:
        db_table = "twitter_tweet_contributors";

class TweetIndex(models.Model):
    keyword = models.CharField(max_length=140)
    tweet = models.ForeignKey(Tweet)

    def getCloudMap(self):
        query_set = TweetIndex.objects.values('keyword').annotate(count=Count('keyword'))
        keyword_map = self.getHashMapFromQuerySet(query_set)

        largest = self.getLargestValueFromMap(keyword_map)
        smallest = self.getSmallestValueFromMap(keyword_map)
        spread = self.getSpread(largest, smallest)
            
        min_font_size = TWITTER['keywordcloud']['min_font_size']
        max_font_size = TWITTER['keywordcloud']['max_font_size']
        step = self.calculateFontSizeIncrement(max_font_size, min_font_size, spread)
        
        sizes = self.querySetToTweetIndexCount(query_set, min_font_size, smallest, step)
            
        return sizes
    
    def getLargestValueFromMap(self, a_map):
        key_of_largest_value = max(a_map, key=a_map.get) 
        
        return int(a_map[key_of_largest_value])
    
    def getSmallestValueFromMap(self, a_map):
        key_of_smallest_value = min(a_map, key=a_map.get) 
        
        return int(a_map[key_of_smallest_value])
    
    def getHashMapFromQuerySet(self, the_query_set):
        keyword_map = {}
        for entry in the_query_set:
            keyword_map[entry['keyword']] = entry['count']
            
        return keyword_map
    
    def getSumOfHashMapValues(self, a_map):
        value_sum = 0
        for key in a_map:
            value_sum += int(a_map[key])
            
        return value_sum
    
    
    def getSpread(self, largest, smallest):
        spread = largest - smallest
        if(spread < 1):
            spread = 1
            
        return spread
    
    def calculateFontSizeIncrement(self, max_font_size, min_font_size, spread):
        return (max_font_size - min_font_size) / spread
    
    def querySetToTweetIndexCount(self, the_query_set, min_font_size, smallest_value, step):
        tweet_index_count_array = []
        if len(the_query_set) == 0:
            return []
        for row in the_query_set:
            new_font_size = min_font_size + (row['count'] - smallest_value) * step
            tweet_index_count_array.append(TweetIndexCount(keyword=row["keyword"], count=new_font_size))
            
        return tweet_index_count_array
    
    def __unicode__(self):
        return self.keyword
    
class TweetIndexCount(models.Model):
    class Meta:
        managed = False
    
    keyword = models.CharField(max_length=140)
    count = models.IntegerField()
