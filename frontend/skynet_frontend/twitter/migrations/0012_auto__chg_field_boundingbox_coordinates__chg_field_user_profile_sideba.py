# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Changing field 'BoundingBox.coordinates'
        db.alter_column('twitter_boundingbox', 'coordinates', self.gf('django.db.models.fields.TextField')(default=''))

        # Changing field 'User.profile_sidebar_fill_color'
        db.alter_column('twitter_user', 'profile_sidebar_fill_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.profile_text_color'
        db.alter_column('twitter_user', 'profile_text_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.profile_sidebar_border_color'
        db.alter_column('twitter_user', 'profile_sidebar_border_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.description'
        db.alter_column('twitter_user', 'description', self.gf('django.db.models.fields.CharField')(max_length=160, null=True))

        # Changing field 'User.profile_link_color'
        db.alter_column('twitter_user', 'profile_link_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.profile_image_url'
        db.alter_column('twitter_user', 'profile_image_url', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.profile_background_color'
        db.alter_column('twitter_user', 'profile_background_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.screen_name'
        db.alter_column('twitter_user', 'screen_name', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'User.language'
        db.alter_column('twitter_user', 'language_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Language'], null=True))

        # Changing field 'User.created_at'
        db.alter_column('twitter_user', 'created_at', self.gf('django.db.models.fields.DateTimeField')(null=True))

        # Changing field 'User.time_zone'
        db.alter_column('twitter_user', 'time_zone_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.TimeZone'], null=True))

        # Changing field 'User.place'
        db.alter_column('twitter_user', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Place'], null=True))

        # Changing field 'Place.bounding_box'
        db.alter_column('twitter_place', 'bounding_box_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.BoundingBox'], null=True))

        # Changing field 'Place.country'
        db.alter_column('twitter_place', 'country_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Country'], null=True))

        # Changing field 'Place.twitter_id'
        db.alter_column('twitter_place', 'twitter_id', self.gf('django.db.models.fields.BigIntegerField')(null=True))

        # Changing field 'Place.place_type'
        db.alter_column('twitter_place', 'place_type_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.PlaceType'], null=True))

        # Changing field 'Place.full_name'
        db.alter_column('twitter_place', 'full_name', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'Place.street_address'
        db.alter_column('twitter_place', 'street_address', self.gf('django.db.models.fields.CharField')(max_length=255, null=True))

        # Changing field 'Tweet.created_at'
        db.alter_column('twitter_tweet', 'created_at', self.gf('django.db.models.fields.DateTimeField')(null=True))

        # Changing field 'Tweet.twitter_id'
        db.alter_column('twitter_tweet', 'twitter_id', self.gf('django.db.models.fields.BigIntegerField')(null=True))

        # Changing field 'Tweet.source_type'
        db.alter_column('twitter_tweet', 'source_type_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.SourceType'], null=True))

        # Changing field 'Tweet.place'
        db.alter_column('twitter_tweet', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Place'], null=True))

        # Changing field 'Tweet.user'
        db.alter_column('twitter_tweet', 'user_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.User'], null=True))


    def backwards(self, orm):
        
        # Changing field 'BoundingBox.coordinates'
        db.alter_column('twitter_boundingbox', 'coordinates', self.gf('django.db.models.fields.TextField')(null=True))

        # Changing field 'User.profile_sidebar_fill_color'
        db.alter_column('twitter_user', 'profile_sidebar_fill_color', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.profile_text_color'
        db.alter_column('twitter_user', 'profile_text_color', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.profile_sidebar_border_color'
        db.alter_column('twitter_user', 'profile_sidebar_border_color', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.description'
        db.alter_column('twitter_user', 'description', self.gf('django.db.models.fields.CharField')(default='', max_length=160))

        # Changing field 'User.profile_link_color'
        db.alter_column('twitter_user', 'profile_link_color', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.profile_image_url'
        db.alter_column('twitter_user', 'profile_image_url', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.profile_background_color'
        db.alter_column('twitter_user', 'profile_background_color', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.screen_name'
        db.alter_column('twitter_user', 'screen_name', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'User.language'
        db.alter_column('twitter_user', 'language_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.Language']))

        # Changing field 'User.created_at'
        db.alter_column('twitter_user', 'created_at', self.gf('django.db.models.fields.DateTimeField')(default=''))

        # Changing field 'User.time_zone'
        db.alter_column('twitter_user', 'time_zone_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.TimeZone']))

        # Changing field 'User.place'
        db.alter_column('twitter_user', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.Place']))

        # Changing field 'Place.bounding_box'
        db.alter_column('twitter_place', 'bounding_box_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.BoundingBox']))

        # Changing field 'Place.country'
        db.alter_column('twitter_place', 'country_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.Country']))

        # Changing field 'Place.twitter_id'
        db.alter_column('twitter_place', 'twitter_id', self.gf('django.db.models.fields.BigIntegerField')(default=''))

        # Changing field 'Place.place_type'
        db.alter_column('twitter_place', 'place_type_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.PlaceType']))

        # Changing field 'Place.full_name'
        db.alter_column('twitter_place', 'full_name', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'Place.street_address'
        db.alter_column('twitter_place', 'street_address', self.gf('django.db.models.fields.CharField')(default='', max_length=255))

        # Changing field 'Tweet.created_at'
        db.alter_column('twitter_tweet', 'created_at', self.gf('django.db.models.fields.DateTimeField')(default=''))

        # Changing field 'Tweet.twitter_id'
        db.alter_column('twitter_tweet', 'twitter_id', self.gf('django.db.models.fields.BigIntegerField')(default=''))

        # Changing field 'Tweet.source_type'
        db.alter_column('twitter_tweet', 'source_type_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.SourceType']))

        # Changing field 'Tweet.place'
        db.alter_column('twitter_tweet', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.Place']))

        # Changing field 'Tweet.user'
        db.alter_column('twitter_tweet', 'user_id', self.gf('django.db.models.fields.related.ForeignKey')(default='', to=orm['twitter.User']))


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bounding_box_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']"}),
            'coordinates': ('django.db.models.fields.TextField', [], {}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.boundingboxtype': {
            'Meta': {'object_name': 'BoundingBoxType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10'})
        },
        'twitter.country': {
            'Meta': {'object_name': 'Country'},
            'code': ('django.db.models.fields.CharField', [], {'max_length': '2'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255'})
        },
        'twitter.hashtag': {
            'Meta': {'object_name': 'Hashtag'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '139'})
        },
        'twitter.language': {
            'Meta': {'object_name': 'Language'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '2'})
        },
        'twitter.place': {
            'Meta': {'object_name': 'Place'},
            'appid': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'bounding_box': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBox']", 'null': 'True'}),
            'country': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Country']", 'null': 'True'}),
            'full_name': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'iso3': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'locality': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'phone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'place_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.PlaceType']", 'null': 'True'}),
            'postal_code': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'region': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'street_address': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'twitter': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'})
        },
        'twitter.placetype': {
            'Meta': {'object_name': 'PlaceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10'})
        },
        'twitter.sourcetype': {
            'Meta': {'object_name': 'SourceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10'})
        },
        'twitter.timezone': {
            'Meta': {'object_name': 'TimeZone'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'time_zone': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'utc_offset': ('django.db.models.fields.IntegerField', [], {})
        },
        'twitter.tweet': {
            'Meta': {'object_name': 'Tweet'},
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True'}),
            'created_at': ('django.db.models.fields.DateTimeField', [], {'null': 'True'}),
            'favorited': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'geo': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'hashtags': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Hashtag']", 'symmetrical': 'False'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'in_reply_to_tweet_twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'in_reply_to_user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']", 'null': 'True'}),
            'retweet_count': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'source_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.SourceType']", 'null': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'truncated': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'urls': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Url']", 'symmetrical': 'False'}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']", 'null': 'True'})
        },
        'twitter.tweetcontributor': {
            'Meta': {'object_name': 'TweetContributor', 'db_table': "'twitter_tweet_contributors'"},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {})
        },
        'twitter.tweetindex': {
            'Meta': {'object_name': 'TweetIndex'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"})
        },
        'twitter.tweetindexcount': {
            'Meta': {'object_name': 'TweetIndexCount', 'managed': 'False'},
            'count': ('django.db.models.fields.IntegerField', [], {}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'})
        },
        'twitter.tweetmention': {
            'Meta': {'object_name': 'TweetMention', 'db_table': "'twitter_tweet_mentions'"},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {})
        },
        'twitter.url': {
            'Meta': {'object_name': 'Url'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255'})
        },
        'twitter.user': {
            'Meta': {'object_name': 'User'},
            'contributors_enabled': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'created_at': ('django.db.models.fields.DateTimeField', [], {'null': 'True'}),
            'default_profile': ('django.db.models.fields.BooleanField', [], {'default': 'True'}),
            'default_profile_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'description': ('django.db.models.fields.CharField', [], {'max_length': '160', 'null': 'True'}),
            'favourites_count': ('django.db.models.fields.BigIntegerField', [], {'default': '0'}),
            'follow_request_sent': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'followers_count': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'following': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'friends_count': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'geo_enabled': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'is_translator': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'language': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Language']", 'null': 'True'}),
            'listed_count': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'name': ('django.db.models.fields.CharField', [], {'default': "''", 'max_length': '255'}),
            'notifications': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']", 'null': 'True'}),
            'profile_background_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_background_image_url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_background_image_url_https': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_background_tile': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'profile_image_url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_link_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_sidebar_border_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_sidebar_fill_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_text_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_use_background_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'protected': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'screen_name': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'show_all_inline_media': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'statuses_count': ('django.db.models.fields.IntegerField', [], {'default': '0'}),
            'time_zone': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']", 'null': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
