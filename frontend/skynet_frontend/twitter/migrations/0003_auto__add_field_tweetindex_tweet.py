# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding field 'TweetIndex.tweet'
        db.add_column('twitter_tweetindex', 'tweet', self.gf('django.db.models.fields.related.ForeignKey')(default=1, to=orm['twitter.Tweet']), keep_default=False)


    def backwards(self, orm):
        
        # Deleting field 'TweetIndex.tweet'
        db.delete_column('twitter_tweetindex', 'tweet_id')


    models = {
        'twitter.tweet': {
            'Meta': {'object_name': 'Tweet'},
            'body': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'datetime': ('django.db.models.fields.DateTimeField', [], {}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '15'})
        },
        'twitter.tweetindex': {
            'Meta': {'object_name': 'TweetIndex'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'tweet': ('django.db.models.fields.related.ForeignKey', [], {'to': "orm['twitter.Tweet']"})
        }
    }

    complete_apps = ['twitter']
