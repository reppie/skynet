# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'TweetContributor'
        db.create_table('twitter_tweetcontributor', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('tweet_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'])),
            ('user_twitter_id', self.gf('django.db.models.fields.BigIntegerField')()),
        ))
        db.send_create_signal('twitter', ['TweetContributor'])

        # Adding model 'Country'
        db.create_table('twitter_country', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('country_code', self.gf('django.db.models.fields.CharField')(max_length=2)),
            ('country_text', self.gf('django.db.models.fields.CharField')(max_length=255)),
        ))
        db.send_create_signal('twitter', ['Country'])

        # Adding model 'Url'
        db.create_table('twitter_url', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('url_text', self.gf('django.db.models.fields.CharField')(max_length=255)),
        ))
        db.send_create_signal('twitter', ['Url'])

        # Adding model 'BoundingBox'
        db.create_table('twitter_boundingbox', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('bb_type_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.BoundingBoxType'])),
            ('coordinates', self.gf('django.db.models.fields.TextField')(null=True)),
        ))
        db.send_create_signal('twitter', ['BoundingBox'])

        # Adding model 'TimeZone'
        db.create_table('twitter_timezone', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('utc_offset', self.gf('django.db.models.fields.IntegerField')()),
            ('time_zone', self.gf('django.db.models.fields.CharField')(max_length=255)),
        ))
        db.send_create_signal('twitter', ['TimeZone'])

        # Adding model 'PlaceType'
        db.create_table('twitter_placetype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('place_type_text', self.gf('django.db.models.fields.CharField')(max_length=10)),
        ))
        db.send_create_signal('twitter', ['PlaceType'])

        # Adding model 'SourceType'
        db.create_table('twitter_sourcetype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('source_type_text', self.gf('django.db.models.fields.CharField')(max_length=10)),
        ))
        db.send_create_signal('twitter', ['SourceType'])

        # Adding model 'User'
        db.create_table('twitter_user', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('twitter_id', self.gf('django.db.models.fields.BigIntegerField')()),
            ('place_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Place'])),
            ('default_profile', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('statuses_count', self.gf('django.db.models.fields.IntegerField')()),
            ('profile_background_tile', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('lang_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Language'])),
            ('profile_link_color', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('following', self.gf('django.db.models.fields.IntegerField')()),
            ('favourites_count', self.gf('django.db.models.fields.BigIntegerField')()),
            ('protected', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('profile_text_color', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('verified', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('contributors_enabled', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('description', self.gf('django.db.models.fields.CharField')(max_length=160)),
            ('name', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('profile_sidebar_border_color', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('profile_background_color', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('created_at', self.gf('django.db.models.fields.DateTimeField')()),
            ('default_profile_image', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('followers_count', self.gf('django.db.models.fields.IntegerField')()),
            ('geo_enabled', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('profile_background_image_url', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('profile_background_image_url_https', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('follow_request_sent', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('url', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('time_zone_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.TimeZone'])),
            ('notifications', self.gf('django.db.models.fields.IntegerField')()),
            ('profile_use_background_image', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('friends_count', self.gf('django.db.models.fields.IntegerField')()),
            ('profile_sidebar_fill_color', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('screen_name', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('profile_image_url', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('show_all_inline_media', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('is_translator', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('listed_count', self.gf('django.db.models.fields.IntegerField')()),
        ))
        db.send_create_signal('twitter', ['User'])

        # Adding model 'TweetMention'
        db.create_table('twitter_tweetmention', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('tweet_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Tweet'])),
            ('user_twitter_id', self.gf('django.db.models.fields.BigIntegerField')()),
        ))
        db.send_create_signal('twitter', ['TweetMention'])

        # Adding model 'Place'
        db.create_table('twitter_place', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('twitter_id', self.gf('django.db.models.fields.BigIntegerField')()),
            ('place_type_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.PlaceType'])),
            ('bb_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.BoundingBox'])),
            ('name', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('full_name', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('country_id', self.gf('django.db.models.fields.related.ForeignKey')(to=orm['twitter.Country'])),
            ('street_address', self.gf('django.db.models.fields.CharField')(max_length=255)),
            ('locality', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('region', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('iso3', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('postal_code', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('phone', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('twitter', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('url', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
            ('appid', self.gf('django.db.models.fields.CharField')(max_length=255, null=True)),
        ))
        db.send_create_signal('twitter', ['Place'])

        # Adding model 'Hashtag'
        db.create_table('twitter_hashtag', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('hastag_text', self.gf('django.db.models.fields.CharField')(max_length=139)),
        ))
        db.send_create_signal('twitter', ['Hashtag'])

        # Adding model 'BoundingBoxType'
        db.create_table('twitter_boundingboxtype', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('bb_type_text', self.gf('django.db.models.fields.CharField')(max_length=10)),
        ))
        db.send_create_signal('twitter', ['BoundingBoxType'])

        # Adding model 'Language'
        db.create_table('twitter_language', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('lang_text', self.gf('django.db.models.fields.CharField')(max_length=2)),
        ))
        db.send_create_signal('twitter', ['Language'])

        # Deleting field 'Tweet.body'
        db.delete_column('twitter_tweet', 'body')

        # Deleting field 'Tweet.username'
        db.delete_column('twitter_tweet', 'username')

        # Deleting field 'Tweet.datetime'
        db.delete_column('twitter_tweet', 'datetime')

        # Adding field 'Tweet.text'
        db.add_column('twitter_tweet', 'text', self.gf('django.db.models.fields.CharField')(default='', max_length=140), keep_default=False)

        # Adding field 'Tweet.geo'
        db.add_column('twitter_tweet', 'geo', self.gf('django.db.models.fields.CharField')(max_length=255, null=True), keep_default=False)

        # Adding field 'Tweet.truncated'
        db.add_column('twitter_tweet', 'truncated', self.gf('django.db.models.fields.BooleanField')(default=False), keep_default=False)

        # Adding field 'Tweet.source_type_id'
        db.add_column('twitter_tweet', 'source_type_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.SourceType']), keep_default=False)

        # Adding field 'Tweet.favorited'
        db.add_column('twitter_tweet', 'favorited', self.gf('django.db.models.fields.BooleanField')(default=False), keep_default=False)

        # Adding field 'Tweet.in_reply_to_tweet_twitter_id'
        db.add_column('twitter_tweet', 'in_reply_to_tweet_twitter_id', self.gf('django.db.models.fields.BigIntegerField')(null=True), keep_default=False)

        # Adding field 'Tweet.in_reply_to_user_twitter_id'
        db.add_column('twitter_tweet', 'in_reply_to_user_twitter_id', self.gf('django.db.models.fields.BigIntegerField')(null=True), keep_default=False)

        # Adding field 'Tweet.retweet_count'
        db.add_column('twitter_tweet', 'retweet_count', self.gf('django.db.models.fields.IntegerField')(default=0), keep_default=False)

        # Adding field 'Tweet.created_at'
        db.add_column('twitter_tweet', 'created_at', self.gf('django.db.models.fields.DateTimeField')(default=datetime.datetime(2011, 10, 25, 12, 14, 39, 179249)), keep_default=False)

        # Adding field 'Tweet.place_id'
        db.add_column('twitter_tweet', 'place_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Place']), keep_default=False)

        # Adding field 'Tweet.user_id'
        db.add_column('twitter_tweet', 'user_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.User']), keep_default=False)

        # Adding field 'Tweet.coordinates'
        db.add_column('twitter_tweet', 'coordinates', self.gf('django.db.models.fields.TextField')(null=True), keep_default=False)

        # Adding M2M table for field urls on 'Tweet'
        db.create_table('twitter_tweet_urls', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('url', models.ForeignKey(orm['twitter.url'], null=False))
        ))
        db.create_unique('twitter_tweet_urls', ['tweet_id', 'url_id'])

        # Adding M2M table for field hastags on 'Tweet'
        db.create_table('twitter_tweet_hastags', (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('tweet', models.ForeignKey(orm['twitter.tweet'], null=False)),
            ('hashtag', models.ForeignKey(orm['twitter.hashtag'], null=False))
        ))
        db.create_unique('twitter_tweet_hastags', ['tweet_id', 'hashtag_id'])

        # Deleting field 'TweetIndex.tweet'
        db.delete_column('twitter_tweetindex', 'tweet_id')

        # Adding field 'TweetIndex.tweet_id'
        db.add_column('twitter_tweetindex', 'tweet_id', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)


    def backwards(self, orm):
        
        # Deleting model 'TweetContributor'
        db.delete_table('twitter_tweetcontributor')

        # Deleting model 'Country'
        db.delete_table('twitter_country')

        # Deleting model 'Url'
        db.delete_table('twitter_url')

        # Deleting model 'BoundingBox'
        db.delete_table('twitter_boundingbox')

        # Deleting model 'TimeZone'
        db.delete_table('twitter_timezone')

        # Deleting model 'PlaceType'
        db.delete_table('twitter_placetype')

        # Deleting model 'SourceType'
        db.delete_table('twitter_sourcetype')

        # Deleting model 'User'
        db.delete_table('twitter_user')

        # Deleting model 'TweetMention'
        db.delete_table('twitter_tweetmention')

        # Deleting model 'Place'
        db.delete_table('twitter_place')

        # Deleting model 'Hashtag'
        db.delete_table('twitter_hashtag')

        # Deleting model 'BoundingBoxType'
        db.delete_table('twitter_boundingboxtype')

        # Deleting model 'Language'
        db.delete_table('twitter_language')

        # Adding field 'Tweet.body'
        db.add_column('twitter_tweet', 'body', self.gf('django.db.models.fields.CharField')(default='', max_length=140), keep_default=False)

        # Adding field 'Tweet.username'
        db.add_column('twitter_tweet', 'username', self.gf('django.db.models.fields.CharField')(default='', max_length=15), keep_default=False)

        # Adding field 'Tweet.datetime'
        db.add_column('twitter_tweet', 'datetime', self.gf('django.db.models.fields.DateTimeField')(default=datetime.datetime(2011, 10, 25, 12, 14, 17, 333960)), keep_default=False)

        # Deleting field 'Tweet.text'
        db.delete_column('twitter_tweet', 'text')

        # Deleting field 'Tweet.geo'
        db.delete_column('twitter_tweet', 'geo')

        # Deleting field 'Tweet.truncated'
        db.delete_column('twitter_tweet', 'truncated')

        # Deleting field 'Tweet.source_type_id'
        db.delete_column('twitter_tweet', 'source_type_id_id')

        # Deleting field 'Tweet.favorited'
        db.delete_column('twitter_tweet', 'favorited')

        # Deleting field 'Tweet.in_reply_to_tweet_twitter_id'
        db.delete_column('twitter_tweet', 'in_reply_to_tweet_twitter_id')

        # Deleting field 'Tweet.in_reply_to_user_twitter_id'
        db.delete_column('twitter_tweet', 'in_reply_to_user_twitter_id')

        # Deleting field 'Tweet.retweet_count'
        db.delete_column('twitter_tweet', 'retweet_count')

        # Deleting field 'Tweet.created_at'
        db.delete_column('twitter_tweet', 'created_at')

        # Deleting field 'Tweet.place_id'
        db.delete_column('twitter_tweet', 'place_id_id')

        # Deleting field 'Tweet.user_id'
        db.delete_column('twitter_tweet', 'user_id_id')

        # Deleting field 'Tweet.coordinates'
        db.delete_column('twitter_tweet', 'coordinates')

        # Removing M2M table for field urls on 'Tweet'
        db.delete_table('twitter_tweet_urls')

        # Removing M2M table for field hastags on 'Tweet'
        db.delete_table('twitter_tweet_hastags')

        # Adding field 'TweetIndex.tweet'
        db.add_column('twitter_tweetindex', 'tweet', self.gf('django.db.models.fields.related.ForeignKey')(default=0, to=orm['twitter.Tweet']), keep_default=False)

        # Deleting field 'TweetIndex.tweet_id'
        db.delete_column('twitter_tweetindex', 'tweet_id_id')


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
            'hastag_text': ('django.db.models.fields.CharField', [], {'max_length': '139'}),
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
            'hastags': ('django.db.models.fields.related.ManyToManyField', [], {'to': "orm['twitter.Hashtag']", 'symmetrical': 'False'}),
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
