# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding unique constraint on 'Geo', fields ['coordinates']
        db.create_unique('twitter_geo', ['coordinates'])

        # Adding unique constraint on 'BoundingBox', fields ['coordinates']
        db.create_unique('twitter_boundingbox', ['coordinates'])


    def backwards(self, orm):
        
        # Removing unique constraint on 'BoundingBox', fields ['coordinates']
        db.delete_unique('twitter_boundingbox', ['coordinates'])

        # Removing unique constraint on 'Geo', fields ['coordinates']
        db.delete_unique('twitter_geo', ['coordinates'])


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bounding_box_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']", 'null': 'True', 'blank': 'True'}),
            'coordinates': ('django.db.models.fields.CharField', [], {'max_length': '255', 'unique': 'True', 'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.boundingboxtype': {
            'Meta': {'object_name': 'BoundingBoxType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.country': {
            'Meta': {'object_name': 'Country'},
            'code': ('django.db.models.fields.CharField', [], {'max_length': '4', 'null': 'True', 'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.geo': {
            'Meta': {'object_name': 'Geo'},
            'coordinates': ('django.db.models.fields.CharField', [], {'max_length': '255', 'unique': 'True', 'null': 'True', 'blank': 'True'}),
            'geo_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.GeoType']", 'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.geotype': {
            'Meta': {'object_name': 'GeoType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.hashtag': {
            'Meta': {'object_name': 'Hashtag'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '139', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.keyword': {
            'Meta': {'object_name': 'Keyword'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'unique': 'True', 'max_length': '140'})
        },
        'twitter.language': {
            'Meta': {'object_name': 'Language'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '4', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.place': {
            'Meta': {'object_name': 'Place'},
            'appid': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'bounding_box': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBox']", 'null': 'True', 'blank': 'True'}),
            'country': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Country']", 'null': 'True', 'blank': 'True'}),
            'full_name': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'primary_key': 'True'}),
            'iso3': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'locality': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'phone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'place_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.PlaceType']", 'null': 'True', 'blank': 'True'}),
            'postal_code': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'region': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'street_address': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'twitter': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'url': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Url']", 'null': 'True', 'blank': 'True'})
        },
        'twitter.placetype': {
            'Meta': {'object_name': 'PlaceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.sourcetype': {
            'Meta': {'object_name': 'SourceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255', 'unique': 'True', 'null': 'True', 'blank': 'True'})
        },
        'twitter.timezone': {
            'Meta': {'object_name': 'TimeZone'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'time_zone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'unique': 'True', 'null': 'True', 'blank': 'True'}),
            'utc_offset': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'})
        },
        'twitter.tweet': {
            'Meta': {'ordering': "['-created_at']", 'object_name': 'Tweet'},
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True', 'blank': 'True'}),
            'created_at': ('django.db.models.fields.DateTimeField', [], {'null': 'True'}),
            'favorited': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'geo': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Geo']", 'null': 'True', 'blank': 'True'}),
            'hashtags': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Hashtag']", 'symmetrical': 'False', 'blank': 'True'}),
            'id': ('django.db.models.fields.BigIntegerField', [], {'primary_key': 'True'}),
            'in_reply_to_tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']", 'null': 'True', 'blank': 'True'}),
            'in_reply_to_user': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_in_reply_to_user'", 'null': 'True', 'to': "orm['twitter.User']"}),
            'keywords': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Keyword']", 'symmetrical': 'False', 'through': "orm['twitter.TweetKeyword']", 'blank': 'True'}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']", 'null': 'True', 'blank': 'True'}),
            'retweet_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'source_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.SourceType']", 'null': 'True', 'blank': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '140', 'null': 'True'}),
            'truncated': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'urls': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Url']", 'symmetrical': 'False', 'blank': 'True'}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']", 'null': 'True'})
        },
        'twitter.tweetcontributor': {
            'Meta': {'object_name': 'TweetContributor', 'db_table': "'twitter_tweet_contributors'"},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']"})
        },
        'twitter.tweetkeyword': {
            'Meta': {'object_name': 'TweetKeyword', 'db_table': "'twitter_tweet_keywords'"},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Keyword']"}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'value': ('django.db.models.fields.CharField', [], {'max_length': '140'})
        },
        'twitter.tweetmention': {
            'Meta': {'object_name': 'TweetMention', 'db_table': "'twitter_tweet_mentions'"},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']"})
        },
        'twitter.url': {
            'Meta': {'object_name': 'Url'},
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'primary_key': 'True'})
        },
        'twitter.user': {
            'Meta': {'object_name': 'User'},
            'contributors_enabled': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'created_at': ('django.db.models.fields.DateTimeField', [], {'null': 'True', 'blank': 'True'}),
            'default_profile': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'default_profile_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'description': ('django.db.models.fields.CharField', [], {'max_length': '160', 'null': 'True', 'blank': 'True'}),
            'favourites_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'follow_request_sent': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'followers_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'following': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'friends_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'geo_enabled': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'id': ('django.db.models.fields.BigIntegerField', [], {'primary_key': 'True'}),
            'is_translator': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'language': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Language']", 'null': 'True', 'blank': 'True'}),
            'listed_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '20', 'null': 'True'}),
            'notifications': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']", 'null': 'True', 'blank': 'True'}),
            'profile_background_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'profile_background_image_url': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_profile_background_image_url'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'profile_background_image_url_https': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_profile_background_image_url_https'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'profile_background_tile': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'profile_image_url': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_profile_image_url'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'profile_image_url_https': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_profile_image_url_https'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'profile_link_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'profile_sidebar_border_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'profile_sidebar_fill_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'profile_text_color': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'profile_use_background_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'protected': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'screen_name': ('django.db.models.fields.CharField', [], {'max_length': '15', 'null': 'True', 'blank': 'True'}),
            'show_all_inline_media': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'statuses_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'time_zone': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']", 'null': 'True', 'blank': 'True'}),
            'url': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_url'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
