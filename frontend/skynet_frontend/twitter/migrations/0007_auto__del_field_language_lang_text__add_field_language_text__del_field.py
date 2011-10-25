# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Deleting field 'Language.lang_text'
        db.delete_column('twitter_language', 'lang_text')

        # Adding field 'Language.text'
        db.add_column('twitter_language', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=2), keep_default=False)

        # Deleting field 'BoundingBoxType.bb_type_text'
        db.delete_column('twitter_boundingboxtype', 'bb_type_text')

        # Adding field 'BoundingBoxType.text'
        db.add_column('twitter_boundingboxtype', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'Country.country_text'
        db.delete_column('twitter_country', 'country_text')

        # Deleting field 'Country.country_code'
        db.delete_column('twitter_country', 'country_code')

        # Adding field 'Country.code'
        db.add_column('twitter_country', 'code', self.gf('django.db.models.fields.CharField')(default='', max_length=2), keep_default=False)

        # Adding field 'Country.text'
        db.add_column('twitter_country', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=255), keep_default=False)

        # Deleting field 'PlaceType.place_type_text'
        db.delete_column('twitter_placetype', 'place_type_text')

        # Adding field 'PlaceType.text'
        db.add_column('twitter_placetype', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'SourceType.source_type_text'
        db.delete_column('twitter_sourcetype', 'source_type_text')

        # Adding field 'SourceType.text'
        db.add_column('twitter_sourcetype', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'Hashtag.hashtag_text'
        db.delete_column('twitter_hashtag', 'hashtag_text')

        # Adding field 'Hashtag.text'
        db.add_column('twitter_hashtag', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=139), keep_default=False)

        # Deleting field 'Url.url_text'
        db.delete_column('twitter_url', 'url_text')

        # Adding field 'Url.text'
        db.add_column('twitter_url', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=255), keep_default=False)


    def backwards(self, orm):
        
        # Adding field 'Language.lang_text'
        db.add_column('twitter_language', 'lang_text', self.gf('django.db.models.fields.CharField')(default='', max_length=2), keep_default=False)

        # Deleting field 'Language.text'
        db.delete_column('twitter_language', 'text')

        # Adding field 'BoundingBoxType.bb_type_text'
        db.add_column('twitter_boundingboxtype', 'bb_type_text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'BoundingBoxType.text'
        db.delete_column('twitter_boundingboxtype', 'text')

        # Adding field 'Country.country_text'
        db.add_column('twitter_country', 'country_text', self.gf('django.db.models.fields.CharField')(default='', max_length=255), keep_default=False)

        # Adding field 'Country.country_code'
        db.add_column('twitter_country', 'country_code', self.gf('django.db.models.fields.CharField')(default='', max_length=2), keep_default=False)

        # Deleting field 'Country.code'
        db.delete_column('twitter_country', 'code')

        # Deleting field 'Country.text'
        db.delete_column('twitter_country', 'text')

        # Adding field 'PlaceType.place_type_text'
        db.add_column('twitter_placetype', 'place_type_text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'PlaceType.text'
        db.delete_column('twitter_placetype', 'text')

        # Adding field 'SourceType.source_type_text'
        db.add_column('twitter_sourcetype', 'source_type_text', self.gf('django.db.models.fields.CharField')(default='', max_length=10), keep_default=False)

        # Deleting field 'SourceType.text'
        db.delete_column('twitter_sourcetype', 'text')

        # Adding field 'Hashtag.hashtag_text'
        db.add_column('twitter_hashtag', 'hashtag_text', self.gf('django.db.models.fields.CharField')(default='', max_length=139), keep_default=False)

        # Deleting field 'Hashtag.text'
        db.delete_column('twitter_hashtag', 'text')

        # Adding field 'Url.url_text'
        db.add_column('twitter_url', 'url_text', self.gf('django.db.models.fields.CharField')(default='', max_length=255), keep_default=False)

        # Deleting field 'Url.text'
        db.delete_column('twitter_url', 'text')


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bb_type_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']"}),
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
