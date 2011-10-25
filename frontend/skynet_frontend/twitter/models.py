from django.db import models

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
    bb_type_id = models.ForeignKey(BoundingBoxType)
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
    place_type_id = models.ForeignKey(PlaceType)
    bb_id = models.ForeignKey(BoundingBox)
    name = models.CharField(max_length=255)
    url = models.CharField(max_length=255)
    full_name = models.CharField(max_length=255)
    country_id = models.ForeignKey(Country)
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
    place_id = models.ForeignKey(Place)
    default_profile = models.BooleanField()
    statuses_count = models.IntegerField()
    profile_background_tile = models.BooleanField()
    lang_id = models.ForeignKey(Language)
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
    time_zone_id = models.ForeignKey(TimeZone)
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
    geo = models.CharField(max_length=255, null=True) #WTF?
    truncated = models.BooleanField()
    twitter_id = models.BigIntegerField()
    source_type_id = models.ForeignKey(SourceType)
    favorited = models.BooleanField()
    in_reply_to_tweet_twitter_id = models.BigIntegerField(null=True)
    in_reply_to_user_twitter_id = models.BigIntegerField(null=True)
    retweet_count = models.IntegerField()
    created_at = models.DateTimeField()
    place_id = models.ForeignKey(Place)
    user_id = models.ForeignKey(User)
    coordinates = models.TextField(null=True)
    urls = models.ManyToManyField(Url, verbose_name="list of URLs")
    hashtags = models.ManyToManyField(Hashtag, verbose_name="List of hashtags")

class TweetMention(models.Model):
    tweet_id = models.ForeignKey(Tweet)
    user_twitter_id = models.BigIntegerField()

class TweetContributor(models.Model):
    tweet_id = models.ForeignKey(Tweet)
    user_twitter_id = models.BigIntegerField()

class TweetIndex(models.Model):
    keyword = models.CharField(max_length=140)
    tweet_id = models.ForeignKey(Tweet)
