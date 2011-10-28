# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'Url'
        db.create_table('twitter_url', (
            ('text', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, primary_key=True)),
        ))
        db.send_create_signal('twitter', ['Url'])

        # Adding model 'Hashtag'
        db.create_table('twitter_hashtag', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=139, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Hashtag'])

        # Adding model 'Country'
        db.create_table('twitter_country', (
            ('code', self.gf('django.db.models.fields.CharField')(max_length=2, null=True, primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Country'])

        # Adding model 'PlaceType'
        db.create_table('twitter_placetype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=10, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['PlaceType'])

        # Adding model 'GeoType'
        db.create_table('twitter_geotype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=10, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['GeoType'])

        # Adding model 'CoordinatesType'
        db.create_table('twitter_coordinatestype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=10, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['CoordinatesType'])

        # Adding model 'BoundingBoxType'
        db.create_table('twitter_boundingboxtype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=10, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['BoundingBoxType'])

        # Adding model 'BoundingBox'
        db.create_table('twitter_boundingbox', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('bounding_box_type', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.BoundingBoxType'], null=True, blank=True)),
            ('coordinates', self.gf('django.db.models.fields.TextField')(null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['BoundingBox'])

        # Adding model 'Language'
        db.create_table('twitter_language', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=2, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Language'])

        # Adding model 'SourceType'
        db.create_table('twitter_sourcetype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=10, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['SourceType'])

        # Adding model 'TimeZone'
        db.create_table('twitter_timezone', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('utc_offset', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('time_zone', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['TimeZone'])

        # Adding model 'Place'
        db.create_table('twitter_place', (
            ('id', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, primary_key=True)),
            ('place_type', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.PlaceType'], null=True, blank=True)),
            ('bounding_box', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.BoundingBox'], null=True, blank=True)),
            ('name', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('url', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Url'], null=True, blank=True)),
            ('full_name', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('country', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Country'], null=True, blank=True)),
            ('street_address', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('locality', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('region', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('iso3', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('postal_code', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('phone', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('twitter', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('appid', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Place'])

        # Adding model 'Geo'
        db.create_table('twitter_geo', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('geo_type', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.GeoType'], null=True, blank=True)),
            ('coordinates', self.gf('django.db.models.fields.TextField')(null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Geo'])

        # Adding model 'Coordinates'
        db.create_table('twitter_coordinates', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('coordinates_type', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.CoordinatesType'], null=True, blank=True)),
            ('coordinates', self.gf('django.db.models.fields.TextField')(null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Coordinates'])

        # Adding model 'User'
        db.create_table('twitter_user', (
            ('id', self.gf('django.db.models.fields.BigIntegerField')(primary_key=True)),
            ('place', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Place'], null=True, blank=True)),
            ('default_profile', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('statuses_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('profile_background_tile', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('language', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Language'], null=True, blank=True)),
            ('profile_link_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('following', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('favourites_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('protected', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('profile_text_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('verified', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('contributors_enabled', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('description', self.gf('django.db.models.fields.CharField')(max_length=160, null=True, blank=True)),
            ('name', self.gf('django.db.models.fields.CharField')(max_length=15, null=True)),
            ('profile_sidebar_border_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('profile_background_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('created_at', self.gf('django.db.models.fields.DateTimeField')(null=True, blank=True)),
            ('default_profile_image', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('followers_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('profile_image_url', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_profile_image_url', null=True, to=orm['twitter.Url'])),
            ('profile_image_url_https', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_profile_image_url_https', null=True, to=orm['twitter.Url'])),
            ('geo_enabled', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('profile_background_image_url', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_profile_background_image_url', null=True, to=orm['twitter.Url'])),
            ('profile_background_image_url_https', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_profile_background_image_url_https', null=True, to=orm['twitter.Url'])),
            ('follow_request_sent', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('url', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_url', null=True, to=orm['twitter.Url'])),
            ('time_zone', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.TimeZone'], null=True, blank=True)),
            ('notifications', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('profile_use_background_image', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('friends_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('profile_sidebar_fill_color', self.gf('django.db.models.fields.CharField')(max_length=255, null=True, blank=True)),
            ('screen_name', self.gf('django.db.models.fields.CharField')(max_length=20, null=True, blank=True)),
            ('show_all_inline_media', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('is_translator', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('listed_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
        ))
        db.send_create_signal('twitter', ['User'])

        # Adding model 'TweetKeyword'
        db.create_table('twitter_tweet_keywords', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('tweet', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'])),
            ('value', self.gf('django.db.models.fields.CharField')(max_length=140)),
            ('keyword', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Keyword'])),
        ))
        db.send_create_signal('twitter', ['TweetKeyword'])

        # Adding model 'Keyword'
        db.create_table('twitter_keyword', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('keyword', self.gf('django.db.models.fields.CharField')(max_length=140)),
        ))
        db.send_create_signal('twitter', ['Keyword'])

        # Adding model 'Tweet'
        db.create_table('twitter_tweet', (
            ('id', self.gf('django.db.models.fields.BigIntegerField')(primary_key=True)),
            ('text', self.gf('django.db.models.fields.CharField')(max_length=140, null=True)),
            ('geo', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Geo'], null=True, blank=True)),
            ('truncated', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('source_type', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.SourceType'], null=True, blank=True)),
            ('favorited', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('in_reply_to_tweet', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'], null=True, blank=True)),
            ('in_reply_to_user', self.gf('django.db.models.fields.related.ForeignKey')(blank=True, related_name='user_in_reply_to_user', null=True, to=orm['twitter.User'])),
            ('retweet_count', self.gf('django.db.models.fields.IntegerField')(default=0, blank=True)),
            ('created_at', self.gf('django.db.models.fields.DateTimeField')(null=True)),
            ('place', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Place'], null=True, blank=True)),
            ('user', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.User'], null=True)),
            ('coordinates', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Coordinates'], null=True, blank=True)),
        ))
        db.send_create_signal('twitter', ['Tweet'])

        # Adding M2M table for field urls on 'Tweet'
        db.create_table('twitter_tweet_urls', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('url', models.ForeignKey(orm['twitter.url'], null=False))
        ))
        db.create_unique('twitter_tweet_urls', ['tweet_id', 'url_id'])

        # Adding M2M table for field hashtags on 'Tweet'
        db.create_table('twitter_tweet_hashtags', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('hashtag', models.ForeignKey(orm['twitter.hashtag'], null=False))
        ))
        db.create_unique('twitter_tweet_hashtags', ['tweet_id', 'hashtag_id'])

        # Adding model 'TweetMention'
        db.create_table('twitter_tweet_mentions', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('tweet', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'])),
            ('user', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.User'])),
        ))
        db.send_create_signal('twitter', ['TweetMention'])

        # Adding model 'TweetContributor'
        db.create_table('twitter_tweet_contributors', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('tweet', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'])),
            ('user', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.User'])),
        ))
        db.send_create_signal('twitter', ['TweetContributor'])


    def backwards(self, orm):
        
        # Deleting model 'Url'
        db.delete_table('twitter_url')

        # Deleting model 'Hashtag'
        db.delete_table('twitter_hashtag')

        # Deleting model 'Country'
        db.delete_table('twitter_country')

        # Deleting model 'PlaceType'
        db.delete_table('twitter_placetype')

        # Deleting model 'GeoType'
        db.delete_table('twitter_geotype')

        # Deleting model 'CoordinatesType'
        db.delete_table('twitter_coordinatestype')

        # Deleting model 'BoundingBoxType'
        db.delete_table('twitter_boundingboxtype')

        # Deleting model 'BoundingBox'
        db.delete_table('twitter_boundingbox')

        # Deleting model 'Language'
        db.delete_table('twitter_language')

        # Deleting model 'SourceType'
        db.delete_table('twitter_sourcetype')

        # Deleting model 'TimeZone'
        db.delete_table('twitter_timezone')

        # Deleting model 'Place'
        db.delete_table('twitter_place')

        # Deleting model 'Geo'
        db.delete_table('twitter_geo')

        # Deleting model 'Coordinates'
        db.delete_table('twitter_coordinates')

        # Deleting model 'User'
        db.delete_table('twitter_user')

        # Deleting model 'TweetKeyword'
        db.delete_table('twitter_tweet_keywords')

        # Deleting model 'Keyword'
        db.delete_table('twitter_keyword')

        # Deleting model 'Tweet'
        db.delete_table('twitter_tweet')

        # Removing M2M table for field urls on 'Tweet'
        db.delete_table('twitter_tweet_urls')

        # Removing M2M table for field hashtags on 'Tweet'
        db.delete_table('twitter_tweet_hashtags')

        # Deleting model 'TweetMention'
        db.delete_table('twitter_tweet_mentions')

        # Deleting model 'TweetContributor'
        db.delete_table('twitter_tweet_contributors')


    models = {
        'twitter.boundingbox': {
            'Meta': {'object_name': 'BoundingBox'},
            'bounding_box_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.BoundingBoxType']", 'null': 'True', 'blank': 'True'}),
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.boundingboxtype': {
            'Meta': {'object_name': 'BoundingBoxType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'null': 'True', 'blank': 'True'})
        },
        'twitter.coordinates': {
            'Meta': {'object_name': 'Coordinates'},
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True', 'blank': 'True'}),
            'coordinates_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.CoordinatesType']", 'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.coordinatestype': {
            'Meta': {'object_name': 'CoordinatesType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'null': 'True', 'blank': 'True'})
        },
        'twitter.country': {
            'Meta': {'object_name': 'Country'},
            'code': ('django.db.models.fields.CharField', [], {'max_length': '2', 'null': 'True', 'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'})
        },
        'twitter.geo': {
            'Meta': {'object_name': 'Geo'},
            'coordinates': ('django.db.models.fields.TextField', [], {'null': 'True', 'blank': 'True'}),
            'geo_type': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.GeoType']", 'null': 'True', 'blank': 'True'}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'})
        },
        'twitter.geotype': {
            'Meta': {'object_name': 'GeoType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'null': 'True', 'blank': 'True'})
        },
        'twitter.hashtag': {
            'Meta': {'object_name': 'Hashtag'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '139', 'null': 'True', 'blank': 'True'})
        },
        'twitter.keyword': {
            'Meta': {'object_name': 'Keyword'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'})
        },
        'twitter.language': {
            'Meta': {'object_name': 'Language'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '2', 'null': 'True', 'blank': 'True'})
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
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'null': 'True', 'blank': 'True'})
        },
        'twitter.sourcetype': {
            'Meta': {'object_name': 'SourceType'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'text': ('django.db.models.fields.CharField', [], {'max_length': '10', 'null': 'True', 'blank': 'True'})
        },
        'twitter.timezone': {
            'Meta': {'object_name': 'TimeZone'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'time_zone': ('django.db.models.fields.CharField', [], {'max_length': '255', 'null': 'True', 'blank': 'True'}),
            'utc_offset': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'})
        },
        'twitter.tweet': {
            'Meta': {'object_name': 'Tweet'},
            'coordinates': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Coordinates']", 'null': 'True', 'blank': 'True'}),
            'created_at': ('django.db.models.fields.DateTimeField', [], {'null': 'True'}),
            'favorited': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'geo': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Geo']", 'null': 'True', 'blank': 'True'}),
            'hashtags': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Hashtag']", 'symmetrical': 'False', 'blank': 'True'}),
            'id': ('django.db.models.fields.BigIntegerField', [], {'primary_key': 'True'}),
            'in_reply_to_tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']", 'null': 'True', 'blank': 'True'}),
            'in_reply_to_user': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_in_reply_to_user'", 'null': 'True', 'to': "orm['twitter.User']"}),
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
            'name': ('django.db.models.fields.CharField', [], {'max_length': '15', 'null': 'True'}),
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
            'screen_name': ('django.db.models.fields.CharField', [], {'max_length': '20', 'null': 'True', 'blank': 'True'}),
            'show_all_inline_media': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'statuses_count': ('django.db.models.fields.IntegerField', [], {'default': '0', 'blank': 'True'}),
            'time_zone': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.TimeZone']", 'null': 'True', 'blank': 'True'}),
            'url': ('django.db.models.fields.related.ForeignKey', [], {'blank': 'True', 'related_name': "'user_url'", 'null': 'True', 'to': "orm['twitter.Url']"}),
            'verified': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['twitter']
