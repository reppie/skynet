from django.db import models
from django.db.models import Count
from skynet_frontend import settings

class Url(models.Model):
    text = models.CharField(primary_key=True, max_length=255, blank=True, null=True);

class Hashtag(models.Model):
    text = models.CharField(max_length=139, blank=True, null=True)

class Country(models.Model):
    code = models.CharField(primary_key=True, max_length=2, blank=True, null=True)
    text = models.CharField(max_length=255, blank=True, null=True)
    
class PlaceType(models.Model):
    text = models.CharField(max_length=10, blank=True, null=True)
    
class GeoType(models.Model):
    text = models.CharField(max_length=10, blank=True, null=True)
    
class CoordinatesType(models.Model):
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
    id = models.CharField(primary_key=True, max_length=255, blank=True, null=True)
    place_type = models.ForeignKey(PlaceType, blank=True, null=True)
    bounding_box = models.ForeignKey(BoundingBox, blank=True, null=True)
    name = models.CharField(max_length=255, blank=True, null=True)
    url = models.ForeignKey(Url, blank=True, null=True)
    full_name = models.CharField(max_length=255, blank=True, null=True)
    country = models.ForeignKey(Country, blank=True, null=True)
    street_address = models.CharField(max_length=255, blank=True, null=True)
    locality = models.CharField(max_length=255, blank=True, null=True)
    region = models.CharField(max_length=255, blank=True, null=True)
    iso3 = models.CharField(max_length=255, blank=True, null=True)
    postal_code = models.CharField(max_length=255, blank=True, null=True)
    phone = models.CharField(max_length=255, blank=True, null=True)
    twitter = models.CharField(max_length=255, blank=True, null=True)
    appid = models.CharField(max_length=255, blank=True, null=True)

class Geo(models.Model):
    geo_type = models.ForeignKey(GeoType, blank=True, null=True)
    coordinates = models.TextField(blank=True, null=True)
    
class Coordinates(models.Model):
    coordinates_type = models.ForeignKey(CoordinatesType, blank=True, null=True)
    coordinates = models.TextField(blank=True, null=True)  

class User(models.Model):
    id = models.BigIntegerField(primary_key=True)
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
    name = models.CharField(max_length=15, null=True)
    profile_sidebar_border_color = models.CharField(max_length=255, blank=True, null=True)
    profile_background_color = models.CharField(max_length=255, blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    default_profile_image = models.BooleanField(blank=True)
    followers_count = models.IntegerField(blank=True, default=0)
    profile_image_url = models.ForeignKey(Url, blank=True, null=True, related_name="user_profile_image_url")
    profile_image_url_https = models.ForeignKey(Url, blank=True, null=True, related_name="user_profile_image_url_https")
    geo_enabled = models.BooleanField(blank=True)
    profile_background_image_url = models.ForeignKey(Url, blank=True, null=True, related_name="user_profile_background_image_url")
    profile_background_image_url_https = models.ForeignKey(Url, blank=True, null=True, related_name="user_profile_background_image_url_https")
    follow_request_sent = models.BooleanField(blank=True)
    url = models.ForeignKey(Url, blank=True, null=True, related_name="user_url")
    time_zone = models.ForeignKey(TimeZone, blank=True, null=True)
    notifications = models.IntegerField(blank=True, default=0)
    profile_use_background_image = models.BooleanField(blank=True)
    friends_count = models.IntegerField(blank=True, default=0)
    profile_sidebar_fill_color = models.CharField(max_length=255, blank=True, null=True)
    screen_name = models.CharField(max_length=20, blank=True, null=True)
    show_all_inline_media = models.BooleanField(blank=True)
    is_translator = models.BooleanField(blank=True)
    listed_count = models.IntegerField(blank=True, default=0)
    
    def __unicode__(self):
        return self.name

    def to_json(self):
        return {
            'id': self.id,
            'name': self.name,
            'screen_name': self.screen_name,
        }
    

class Keyword(models.Model):
    keyword = models.CharField(max_length=140)

    @staticmethod
    def get_all_since(datetime_since):
        return Keyword.objects.values('keyword').annotate(count=Count('keyword')).filter(tweet__created_at__gte=datetime_since)
    
    @staticmethod
    def get_keyword_cloud():
        from skynet_frontend.keywordcloud.models import KeywordCloud 
        from datetime import datetime, timedelta
        
        yesterday = datetime.now() - timedelta(days=1)
        query_set = Keyword.get_all_since(yesterday)
        min_font_size = settings.TWITTER['keywordcloud']['min_font_size']
        max_font_size = settings.TWITTER['keywordcloud']['max_font_size']
        
        return KeywordCloud(query_set=query_set, min_font_size=min_font_size, max_font_size=max_font_size)
        
    def __unicode__(self):
        return self.keyword

class Tweet(models.Model):
    id = models.BigIntegerField(primary_key=True)
    text = models.CharField(max_length=140, null=True)
    geo = models.ForeignKey(Geo, blank=True, null=True)
    truncated = models.BooleanField(blank=True)
    source_type = models.ForeignKey(SourceType, blank=True, null=True)
    favorited = models.BooleanField(blank=True)
    in_reply_to_tweet = models.ForeignKey('self', blank=True, null=True)
    in_reply_to_user = models.ForeignKey(User, blank=True, null=True, related_name="user_in_reply_to_user")
    retweet_count = models.IntegerField(blank=True, default=0)
    created_at = models.DateTimeField(null=True)
    place = models.ForeignKey(Place, blank=True, null=True)
    user = models.ForeignKey(User, null=True)
    coordinates = models.ForeignKey(Coordinates, blank=True, null=True)
    urls = models.ManyToManyField(Url, verbose_name="list of URLs", blank=True)
    hashtags = models.ManyToManyField(Hashtag, verbose_name="List of hashtags", blank=True)
    keywords = models.ManyToManyField(Keyword, verbose_name="Keywords", blank=True, through='TweetKeyword')
    
    def save(self, *args, **kwargs):
        super(Tweet, self).save(*args, **kwargs)
        words = self.text.split()
        for word in words:
            keyword = Keyword.objects.filter(keyword=word)
            if keyword:
                keyword = keyword[0]
            else:
                keyword = Keyword(keyword=word)
                keyword.save()
            
            relation = TweetKeyword(tweet=self, keyword=keyword)
            relation.save()
    
    def __unicode__(self):
        return "@" + self.user.name + ": " + self.text
    
    def to_json(self):
        return {
            'id': self.id,
            'text': self.text,
            'user_id': self.user_id,
        }
       
class TweetKeyword(models.Model):
    tweet = models.ForeignKey(Tweet)
    value = models.CharField(max_length=140)
    keyword = models.ForeignKey(Keyword)
    
    class Meta:
        db_table = "twitter_tweet_keywords";
 
class TweetMention(models.Model):
    tweet = models.ForeignKey(Tweet)
    user = models.ForeignKey(User)
    
    class Meta:
        db_table = "twitter_tweet_mentions";

class TweetContributor(models.Model):
    tweet = models.ForeignKey(Tweet)
    user = models.ForeignKey(User)

    class Meta:
        db_table = "twitter_tweet_contributors";
