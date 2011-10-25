# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Removing M2M table for field hastags on 'Tweet'
        db.delete_table('twitter_tweet_hastags')

        # Adding M2M table for field hashtags on 'Tweet'
        db.create_table('twitter_tweet_hashtags', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('hashtag', models.ForeignKey(orm['twitter.hashtag'], null=False))
        ))
        db.create_unique('twitter_tweet_hashtags', ['tweet_id', 'hashtag_id'])


    def backwards(self, orm):
        
        # Adding M2M table for field hastags on 'Tweet'
        db.create_table('twitter_tweet_hastags', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('hashtag', models.ForeignKey(orm['twitter.hashtag'], null=False))
        ))
        db.create_unique('twitter_tweet_hastags', ['tweet_id', 'hashtag_id'])

        # Removing M2M table for field hashtags on 'Tweet'
        db.delete_table('twitter_tweet_hashtags')


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bb_type_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']"}),
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.boundingboxtype': {
            'Meta': {'object_name': 'BoundingBoxType'},
            'bb_type_text': ('django.db.models.fields.CharField', [], {'max_length': '10'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.country': {
            'Meta': {'object_name': 'Country'},
            'country_code': ('django.db.models.fields.CharField', [], {'max_length': '2'}),
            'country_text': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.hashtag': {
            'Meta': {'object_name': 'Hashtag'},
            'hashtag_text': ('django.db.models.fields.CharField', [], {'max_length': '139'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.language': {
            'Meta': {'object_name': 'Language'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'lang_text': ('django.db.models.fields.CharField', [], {'max_length': '2'})
        },
        'twitter.place': {
            'Meta': {'object_name': 'Place'},
            'appid': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'bb_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBox']"}),
            'country_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Country']"}),
            'full_name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'iso3': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'locality': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'phone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'place_type_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.PlaceType']"}),
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
            'place_type_text': ('django.db.models.fields.CharField', [], {'max_length': '10'})
        },
        'twitter.sourcetype': {
            'Meta': {'object_name': 'SourceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'source_type_text': ('django.db.models.fields.CharField', [], {'max_length': '10'})
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
            'place_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']"}),
            'retweet_count': ('django.db.models.fields.IntegerField', [], {}),
            'source_type_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.SourceType']"}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'truncated': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'urls': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Url']", 'symmetrical': 'False'}),
            'user_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']"})
        },
        'twitter.tweetcontributor': {
            'Meta': {'object_name': 'TweetContributor'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {})
        },
        'twitter.tweetindex': {
            'Meta': {'object_name': 'TweetIndex'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'tweet_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"})
        },
        'twitter.tweetmention': {
            'Meta': {'object_name': 'TweetMention'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'tweet_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"}),
            'user_twitter_id': ('django.db.models.fields.BigIntegerField', [], {})
        },
        'twitter.url': {
            'Meta': {'object_name': 'Url'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'url_text': ('django.db.models.fields.CharField', [], {'max_length': '255'})
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
            'lang_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Language']"}),
            'listed_count': ('django.db.models.fields.IntegerField', [], {}),
            'name': ('django.db.models.fields.CharField', [], {'max_length': '255'}),
            'notifications': ('django.db.models.fields.IntegerField', [], {}),
            'place_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Place']"}),
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
            'time_zone_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']"}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
