# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Deleting field 'BoundingBox.bb_type'
        db.delete_column('twitter_boundingbox', 'bb_type_id')

        # Adding field 'BoundingBox.bounding_box_type'
        db.add_column('twitter_boundingbox', 'bounding_box_type', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.BoundingBoxType']), keep_default=False)


    def backwards(self, orm):
        
        # Adding field 'BoundingBox.bb_type'
        db.add_column('twitter_boundingbox', 'bb_type', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.BoundingBoxType']), keep_default=False)

        # Deleting field 'BoundingBox.bounding_box_type'
        db.delete_column('twitter_boundingbox', 'bounding_box_type_id')


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bounding_box_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']"}),
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True'}),
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
            'bounding_box': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBox']"}),
            'country': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Country']"}),
            'full_name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'iso3': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'locality': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'phone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'place_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.PlaceType']"}),
            'postal_code': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'region': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'street_address': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'twitter': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
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
            'created_at': ('django.db.models.fields.DateTimeField', [], {}),
            'favorited': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'geo': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'hashtags': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Hashtag']", 'symmetrical': 'False'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'in_reply_to_tweet_twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'in_reply_to_user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {'null': 'True'}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']"}),
            'retweet_count': ('django.db.models.fields.IntegerField', [], {}),
            'source_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.SourceType']"}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'truncated': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'urls': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Url']", 'symmetrical': 'False'}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']"})
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
            'created_at': ('django.db.models.fields.DateTimeField', [], {}),
            'default_profile': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'default_profile_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'description': ('django.db.models.fields.CharField', [], {'max_length': '160'}),
            'favourites_count': ('django.db.models.fields.BigIntegerField', [], {}),
            'follow_request_sent': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'followers_count': ('django.db.models.fields.IntegerField', [], {}),
            'following': ('django.db.models.fields.IntegerField', [], {}),
            'friends_count': ('django.db.models.fields.IntegerField', [], {}),
            'geo_enabled': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'is_translator': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'lang': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Language']"}),
            'listed_count': ('django.db.models.fields.IntegerField', [], {}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'notifications': ('django.db.models.fields.IntegerField', [], {}),
            'place': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']"}),
            'profile_background_color': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_background_image_url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_background_image_url_https': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'profile_background_tile': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'profile_image_url': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_link_color': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_sidebar_border_color': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_sidebar_fill_color': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_text_color': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'profile_use_background_image': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'protected': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'screen_name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'show_all_inline_media': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'statuses_count': ('django.db.models.fields.IntegerField', [], {}),
            'time_zone': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']"}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
