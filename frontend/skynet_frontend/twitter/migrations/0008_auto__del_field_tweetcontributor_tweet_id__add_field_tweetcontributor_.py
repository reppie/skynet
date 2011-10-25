# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Deleting field 'TweetContributor.tweet_id'
        db.delete_column('twitter_tweetcontributor', 'tweet_id_id')

        # Adding field 'TweetContributor.tweet'
        db.add_column('twitter_tweetcontributor', 'tweet', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'TweetIndex.tweet_id'
        db.delete_column('twitter_tweetindex', 'tweet_id_id')

        # Adding field 'TweetIndex.tweet'
        db.add_column('twitter_tweetindex', 'tweet', self.gf('django.db.models.fields.related.ForeignKey')(default=2, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'BoundingBox.bb_type_id'
        db.delete_column('twitter_boundingbox', 'bb_type_id_id')

        # Adding field 'BoundingBox.bb_type'
        db.add_column('twitter_boundingbox', 'bb_type', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.BoundingBoxType']), keep_default=False)

        # Deleting field 'User.place_id'
        db.delete_column('twitter_user', 'place_id_id')

        # Deleting field 'User.lang_id'
        db.delete_column('twitter_user', 'lang_id_id')

        # Adding field 'User.place'
        db.add_column('twitter_user', 'place', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Place']), keep_default=False)

        # Adding field 'User.lang'
        db.add_column('twitter_user', 'lang', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Language']), keep_default=False)

        # Deleting field 'TweetMention.tweet_id'
        db.delete_column('twitter_tweetmention', 'tweet_id_id')

        # Adding field 'TweetMention.tweet'
        db.add_column('twitter_tweetmention', 'tweet', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'Place.country_id'
        db.delete_column('twitter_place', 'country_id_id')

        # Deleting field 'Place.place_type_id'
        db.delete_column('twitter_place', 'place_type_id_id')

        # Adding field 'Place.place_type'
        db.add_column('twitter_place', 'place_type', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.PlaceType']), keep_default=False)

        # Adding field 'Place.country'
        db.add_column('twitter_place', 'country', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Country']), keep_default=False)

        # Deleting field 'Tweet.place_id'
        db.delete_column('twitter_tweet', 'place_id_id')

        # Deleting field 'Tweet.user_id'
        db.delete_column('twitter_tweet', 'user_id_id')

        # Adding field 'Tweet.place'
        db.add_column('twitter_tweet', 'place', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Place']), keep_default=False)

        # Adding field 'Tweet.user'
        db.add_column('twitter_tweet', 'user', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.User']), keep_default=False)


    def backwards(self, orm):
        
        # Adding field 'TweetContributor.tweet_id'
        db.add_column('twitter_tweetcontributor', 'tweet_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'TweetContributor.tweet'
        db.delete_column('twitter_tweetcontributor', 'tweet_id')

        # User chose to not deal with backwards NULL issues for 'TweetIndex.tweet_id'
        raise RuntimeError("Cannot reverse this migration. 'TweetIndex.tweet_id' and its values cannot be restored.")

        # Deleting field 'TweetIndex.tweet'
        db.delete_column('twitter_tweetindex', 'tweet_id')

        # Adding field 'BoundingBox.bb_type_id'
        db.add_column('twitter_boundingbox', 'bb_type_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.BoundingBoxType']), keep_default=False)

        # Deleting field 'BoundingBox.bb_type'
        db.delete_column('twitter_boundingbox', 'bb_type_id')

        # Adding field 'User.place_id'
        db.add_column('twitter_user', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Place']), keep_default=False)

        # Adding field 'User.lang_id'
        db.add_column('twitter_user', 'lang_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Language']), keep_default=False)

        # Deleting field 'User.place'
        db.delete_column('twitter_user', 'place_id')

        # Deleting field 'User.lang'
        db.delete_column('twitter_user', 'lang_id')

        # Adding field 'TweetMention.tweet_id'
        db.add_column('twitter_tweetmention', 'tweet_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'TweetMention.tweet'
        db.delete_column('twitter_tweetmention', 'tweet_id')

        # Adding field 'Place.country_id'
        db.add_column('twitter_place', 'country_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Country']), keep_default=False)

        # Adding field 'Place.place_type_id'
        db.add_column('twitter_place', 'place_type_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.PlaceType']), keep_default=False)

        # Deleting field 'Place.place_type'
        db.delete_column('twitter_place', 'place_type_id')

        # Deleting field 'Place.country'
        db.delete_column('twitter_place', 'country_id')

        # Adding field 'Tweet.place_id'
        db.add_column('twitter_tweet', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Place']), keep_default=False)

        # Adding field 'Tweet.user_id'
        db.add_column('twitter_tweet', 'user_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.User']), keep_default=False)

        # Deleting field 'Tweet.place'
        db.delete_column('twitter_tweet', 'place_id')

        # Deleting field 'Tweet.user'
        db.delete_column('twitter_tweet', 'user_id')


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bb_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']"}),
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
            'source_type_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.SourceType']"}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'truncated': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'urls': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Url']", 'symmetrical': 'False'}),
            'user': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.User']"})
        },
        'twitter.tweetcontributor': {
            'Meta': {'object_name': 'TweetContributor'},
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
            'Meta': {'object_name': 'TweetMention'},
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
            'time_zone_id': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']"}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'url': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True'}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
